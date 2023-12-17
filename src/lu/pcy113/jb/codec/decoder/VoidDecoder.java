package lu.pcy113.jb.codec.decoder;

import java.nio.ByteBuffer;

public class VoidDecoder extends DefaultObjectDecoder<Void> {

	public VoidDecoder() {
		super(Void.class);
	}

	public Void decode(boolean head, ByteBuffer bb) {
		verifyHeader(head, bb);

		return null;
	}

}
