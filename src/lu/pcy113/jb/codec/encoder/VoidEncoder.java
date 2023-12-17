package lu.pcy113.jb.codec.encoder;

import java.nio.ByteBuffer;

public class VoidEncoder extends DefaultObjectEncoder<Void> {

	public VoidEncoder() {
		super(Void.class);
	}

	public ByteBuffer encode(boolean head, Void obj) {
		ByteBuffer bb = ByteBuffer.allocate((head ? 2 : 0));
		if (head)
			bb.putShort(header);

		bb.flip();
		return bb;
	}

}
