package lu.pcy113.jbcodec.decoder;

import java.nio.ByteBuffer;

public class LongDecoder extends DefaultObjectDecoder<Long> {

	public LongDecoder() {
		super(Long.class);
	}

	public Long decode(boolean head, ByteBuffer bb) {
		verifyHeader(head, bb);

		return bb.getLong();
	}

}
