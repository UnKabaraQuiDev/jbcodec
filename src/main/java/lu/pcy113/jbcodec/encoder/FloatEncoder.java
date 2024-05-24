package lu.pcy113.jbcodec.encoder;

import java.nio.ByteBuffer;

public class FloatEncoder extends DefaultObjectEncoder<Float> {

	public FloatEncoder() {
		super(Float.class);
	}

	public ByteBuffer encode(boolean head, Float obj) {
		ByteBuffer bb = ByteBuffer.allocate(8 + (head ? 2 : 0));
		if (head)
			bb.putShort(header);
		bb.putDouble(obj);

		bb.flip();
		return bb;
	}

}
