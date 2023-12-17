package lu.pcy113.jb.codec.encoder;

import java.nio.ByteBuffer;

public class DoubleEncoder extends DefaultObjectEncoder<Double> {

	public DoubleEncoder() {
		super(Double.class);
	}

	public ByteBuffer encode(boolean head, Double obj) {
		ByteBuffer bb = ByteBuffer.allocate(8 + (head ? 2 : 0));
		if (head)
			bb.putShort(header);
		bb.putDouble(obj);

		bb.flip();
		return bb;
	}

}
