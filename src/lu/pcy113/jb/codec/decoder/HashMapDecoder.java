package lu.pcy113.jb.codec.decoder;

import java.nio.ByteBuffer;
import java.util.HashMap;

public class HashMapDecoder extends DefaultObjectDecoder<HashMap<?, ?>> {

	public HashMapDecoder() {
		super(HashMap.class);
	}

	public HashMap<?, ?> decode(boolean head, ByteBuffer bb) {
		if(head) {
			short nheader = bb.getShort();
			if(nheader != header)
				Decoder.decoderNotCompatible(nheader, header);
		}

		int length = bb.getInt();

		HashMap<Object, Object> map = new HashMap<>();

		for(int i = 0; i < length; i++) {
			Object k = cm.decode(bb);
			Object v = cm.decode(bb);
			map.put(k, v);
		}

		return map;
	}

}