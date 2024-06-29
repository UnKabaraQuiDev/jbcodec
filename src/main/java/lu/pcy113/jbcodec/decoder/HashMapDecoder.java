package lu.pcy113.jbcodec.decoder;

import java.nio.ByteBuffer;
import java.util.HashMap;

public class HashMapDecoder extends DefaultObjectDecoder<HashMap<?, ?>> {

	@Override
	public HashMap<?, ?> decode(boolean head, ByteBuffer bb) {
		verifyHeader(head, bb);

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