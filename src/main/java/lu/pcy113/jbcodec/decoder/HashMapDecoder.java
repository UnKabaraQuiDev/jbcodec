package lu.pcy113.jbcodec.decoder;

import java.nio.ByteBuffer;
import java.util.HashMap;

import lu.pcy113.pclib.PCUtils;

public class HashMapDecoder extends DefaultObjectDecoder<HashMap<?, ?>> {

	public HashMapDecoder() {
		super(HashMap.class);
	}

	@Override
	public HashMap<?, ?> decode(boolean head, ByteBuffer bb) {
		verifyHeader(head, bb);

		System.err.println(PCUtils.byteBufferToHexString(bb));
		
		int length = bb.getInt();

		HashMap<Object, Object> map = new HashMap<>();

		for (int i = 0; i < length; i++) {
			Object k = cm.decode(bb);
			Object v = cm.decode(bb);
			map.put(k, v);
		}

		return map;
	}

}