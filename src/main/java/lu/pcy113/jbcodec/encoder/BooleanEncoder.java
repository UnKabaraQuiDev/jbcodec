package lu.pcy113.jbcodec.encoder;

import java.nio.ByteBuffer;

public class BooleanEncoder extends DefaultObjectEncoder<Boolean> {

	public BooleanEncoder() {
		super(Boolean.class);
	}

	public ByteBuffer encode(boolean head, Boolean obj) {
		ByteBuffer bb = ByteBuffer.allocate(1 + (head ? 2 : 0));
		if (head)
			bb.putShort(header);
		bb.put((byte) (obj ? 1 : 0));

		bb.flip();
		return bb;
	}

}
