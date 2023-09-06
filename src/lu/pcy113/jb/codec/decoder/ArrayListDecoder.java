package lu.pcy113.jb.codec.decoder;

import java.nio.ByteBuffer;
import java.util.ArrayList;

public class ArrayListDecoder extends DefaultObjectDecoder<ArrayList<?>> {

	public ArrayListDecoder() {
		super(ArrayList.class);
	}
	public ArrayList<Object> decode(boolean head, ByteBuffer bb) {
		if(head) {
			short nheader = bb.getShort();
			if(nheader != header)
				Decoder.decoderNotCompatible(nheader, header);
		}

		int length = bb.getInt();

		ArrayList<Object> array = new ArrayList<>();
		for(int i = 0; i < length; i++) {
			array.add(cm.decode(bb));
		}
		return array;
	}

}
