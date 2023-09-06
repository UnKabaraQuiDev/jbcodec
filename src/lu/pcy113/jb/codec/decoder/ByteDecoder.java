package lu.pcy113.jb.codec.decoder;

import java.nio.ByteBuffer;

public class ByteDecoder extends DefaultObjectDecoder<Byte> {
	
	public ByteDecoder() {
		super(Byte.class);
	}

	public Byte decode(boolean head, ByteBuffer bb) {
		if(head) {
			short nheader = bb.getShort();
			if(nheader != header)
				Decoder.decoderNotCompatible(nheader, header);
		}

		return bb.get();
	}

}
