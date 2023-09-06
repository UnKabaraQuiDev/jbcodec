package lu.pcy113.jb.codec.encoder;

import java.nio.ByteBuffer;

public class ShortEncoder extends DefaultObjectEncoder<Short> {
	
	public ShortEncoder() {
		super(Short.class);
	}

	public ByteBuffer encode(boolean head, Short obj) {
		ByteBuffer bb = ByteBuffer.allocate(2 + (head ? 2 : 0));
		if(head)
			bb.putShort(header);
		bb.putShort(obj);
		
		bb.flip();
		return bb;
	}

}
