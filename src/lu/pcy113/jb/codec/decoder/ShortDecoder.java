package lu.pcy113.jb.codec.decoder;

import java.nio.ByteBuffer;

public class ShortDecoder extends DefaultObjectDecoder<Short> {
	
	public ShortDecoder() {
		super(Short.class);
	}

	public Short decode(boolean head, ByteBuffer bb) {
		verifyHeader(head, bb);

		return bb.getShort();
	}

}
