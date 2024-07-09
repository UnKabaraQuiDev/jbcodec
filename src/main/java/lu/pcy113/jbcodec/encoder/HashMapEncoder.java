package lu.pcy113.jbcodec.encoder;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map.Entry;

public class HashMapEncoder extends DefaultObjectEncoder<HashMap<?, ?>> {

	public HashMapEncoder() {
		super(HashMap.class);
	}

	/**
	 * ( HEAD 2b - SIZE 4b - DATA >=4b KEY HEAD 2b KEY DATA xb VALUE HEAD 2b VALUE DATA xb
	 */
	@Override
	public ByteBuffer encode(boolean head, HashMap<?, ?> obj) {
		final int length = estimateSize(head, obj);
		final ByteBuffer bb = ByteBuffer.allocate(length);
		super.putHeader(head, bb);
		
		bb.putInt(obj.size());
		
		for (Entry<?, ?> o : obj.entrySet()) {
			Object key = o.getKey();
			Object value = o.getValue();

			bb.put(cm.encode(true, key));
			bb.put(cm.encode(true, value));
		}

		bb.flip();
		return bb;
	}

	@Override
	public int estimateSize(boolean head, HashMap<?, ?> obj) {
		int length = super.estimateHeaderSize(head) + Integer.BYTES;
		for (Entry<?, ?> o : obj.entrySet()) {
			length += cm.estimateSize(true, o.getKey());
			length += cm.estimateSize(true, o.getValue());
		}
		return length;
	}

}
