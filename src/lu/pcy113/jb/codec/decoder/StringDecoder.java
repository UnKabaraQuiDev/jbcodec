package lu.pcy113.jb.codec.decoder;

import java.nio.ByteBuffer;

public class StringDecoder extends DefaultObjectDecoder<String> {
	
	public StringDecoder() {
		super(String.class);
	}

	public String decode(boolean head, ByteBuffer bb) {
		if(head) {
			short nheader = bb.getShort();
			if(nheader != header)
				Decoder.decoderNotCompatible(nheader, header);
		}

		int length = bb.getInt();
		byte[] b = new byte[length];
		bb.get(b);
		return new String(b);
	}

}
