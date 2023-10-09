package lu.pcy113.jb.codec.decoder;

import java.nio.ByteBuffer;

public class BooleanDecoder extends DefaultObjectDecoder<Boolean> {
	
	public BooleanDecoder() {
		super(Boolean.class);
	}
	
	public Boolean decode(boolean head, ByteBuffer bb) {
		verifyHeader(head, bb);

		return bb.get() == 0 ? false : true;
	}
	
}
