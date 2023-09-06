package lu.pcy113.jb.codec.decoder;

import java.nio.ByteBuffer;

public class LongDecoder extends DefaultObjectDecoder<Long> {
	
	public LongDecoder() {
		super(Long.class);
	}

	public Long decode(boolean head, ByteBuffer bb) {
		if(head) {
			short nheader = bb.getShort();
			if(nheader != header)
				Decoder.decoderNotCompatible(nheader, header);
		}

		return bb.getLong();
	}
	
}
