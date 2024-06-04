package lu.pcy113.jbcodec.encoder;

import java.nio.ByteBuffer;

import lu.pcy113.jbcodec.CodecManager;

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

	@Override
	public int estimateSize(boolean head, Object obj) {
		return (head ? CodecManager.HEAD_SIZE : 0);
	}

}
