package lu.pcy113.jbcodec.decoder;

import java.nio.ByteBuffer;

public class IntegerDecoder extends DefaultObjectDecoder<Integer> {

	public IntegerDecoder() {
		super(Integer.class);
	}

	public Integer decode(boolean head, ByteBuffer bb) {
		verifyHeader(head, bb);

		return bb.getInt();
	}

}
