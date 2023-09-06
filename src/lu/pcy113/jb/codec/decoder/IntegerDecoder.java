package lu.pcy113.jb.codec.decoder;

import java.nio.ByteBuffer;

public class IntegerDecoder extends DefaultObjectDecoder<Integer> {
	
	public IntegerDecoder() {
		super(Integer.class);
	}

	public Integer decode(boolean head, ByteBuffer bb) {
		if(head) {
			short nheader = bb.getShort();
			if(nheader != header)
				Decoder.decoderNotCompatible(nheader, header);
		}

		return bb.getInt();
	}

}
