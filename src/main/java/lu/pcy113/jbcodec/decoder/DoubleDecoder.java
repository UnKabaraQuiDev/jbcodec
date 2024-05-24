package lu.pcy113.jbcodec.decoder;

import java.nio.ByteBuffer;

public class DoubleDecoder extends DefaultObjectDecoder<Double> {

	public DoubleDecoder() {
		super(Double.class);
	}

	public Double decode(boolean head, ByteBuffer bb) {
		verifyHeader(head, bb);

		return bb.getDouble();
	}

}
