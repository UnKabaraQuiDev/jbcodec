package lu.pcy113.jb.codec.decoder;

import java.nio.ByteBuffer;

public class VoidDecoder extends DefaultObjectDecoder<Void> {
	
	public VoidDecoder() {
		super(Void.class);
	}

	public Void decode(boolean head, ByteBuffer bb) {
		if(head) {
			short nheader = bb.getShort();
			if(nheader != header)
				Decoder.decoderNotCompatible(nheader, header);
		}

		return null;
	}
	
}
