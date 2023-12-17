package lu.pcy113.jb.codec.decoder;

import java.nio.ByteBuffer;

public class ByteDecoder extends DefaultObjectDecoder<Byte> {

	public ByteDecoder() {
		super(Byte.class);
	}

	public Byte decode(boolean head, ByteBuffer bb) {
		verifyHeader(head, bb);

		return bb.get();
	}

}
