package lu.pcy113.jb.codec.encoder;

import java.nio.ByteBuffer;

public class LongEncoder extends DefaultObjectEncoder<Long> {

	public LongEncoder() {
		super(Long.class);
	}

	public ByteBuffer encode(boolean head, Long obj) {
		ByteBuffer bb = ByteBuffer.allocate(8 + (head ? 2 : 0));
		if (head)
			bb.putShort(header);
		bb.putLong(obj);

		bb.flip();
		return bb;
	}

}
