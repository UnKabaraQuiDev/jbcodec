package lu.pcy113.jb.codec.encoder;

import java.nio.ByteBuffer;

public class NullEncoder extends DefaultObjectEncoder<Object> {

	public NullEncoder() {
		super(Object.class);
	}

	@Override
	public boolean confirmType(Object obj) {
		return obj == null;
	}

	public ByteBuffer encode(boolean head, Object obj) {
		ByteBuffer bb = ByteBuffer.allocate((head ? 2 : 0));
		if (head)
			bb.putShort(header);

		bb.flip();
		return bb;
	}

}
