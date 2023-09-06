package lu.pcy113.jb.codec.encoder;

import java.nio.ByteBuffer;

public class IntegerEncoder extends DefaultObjectEncoder<Integer> {
	
	public IntegerEncoder() {
		super(Integer.class);
	}

	public ByteBuffer encode(boolean head, Integer obj) {
		ByteBuffer bb = ByteBuffer.allocate(4 + (head ? 2 : 0));
		if(head)
			bb.putShort(header);
		bb.putInt(obj);
		
		bb.flip();
		return bb;
	}

}
