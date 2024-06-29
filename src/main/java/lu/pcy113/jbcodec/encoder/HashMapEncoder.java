package lu.pcy113.jbcodec.encoder;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import lu.pcy113.pclib.PCUtils;

public class HashMapEncoder extends DefaultObjectEncoder<HashMap<?, ?>> {

	/**
	 * ( HEAD 2b - SIZE 4b - DATA >=4b KEY HEAD 2b KEY DATA xb VALUE HEAD 2b VALUE DATA xb
	 */
	@Override
	public ByteBuffer encode(boolean head, HashMap<?, ?> obj) {
		List<Byte> elements = new ArrayList<>();
		for (Entry<?, ?> o : obj.entrySet()) {

			Object key = o.getKey();
			Object value = o.getValue();

			elements.addAll(PCUtils.byteArrayToList(cm.encode(true, key).array()));
			elements.addAll(PCUtils.byteArrayToList(cm.encode(true, value).array()));
		}
		ByteBuffer bb = ByteBuffer.allocate((head ? 2 : 0) + 4 + elements.size());
		if (head)
			bb.putShort(header);
		bb.putInt(obj.size());
		bb.put(PCUtils.byteListToPrimitive(elements));

		bb.flip();
		return bb;
	}

}
