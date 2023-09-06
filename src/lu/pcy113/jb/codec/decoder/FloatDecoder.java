package lu.pcy113.jb.codec.decoder;

import java.nio.ByteBuffer;

public class FloatDecoder extends DefaultObjectDecoder<Float> {
	
	public FloatDecoder() {
		super(Float.class);
	}

	public Float decode(boolean head, ByteBuffer bb) {
		if(head) {
			short nheader = bb.getShort();
			if(nheader != header)
				Decoder.decoderNotCompatible(nheader, header);
		}

		return bb.getFloat();
	}

}
