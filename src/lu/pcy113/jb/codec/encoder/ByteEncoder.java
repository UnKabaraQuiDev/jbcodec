package lu.pcy113.jb.codec.encoder;

import java.nio.ByteBuffer;

public class ByteEncoder extends DefaultObjectEncoder<Byte> {
	
	public ByteEncoder() {
		super(Byte.class);
	}

	public ByteBuffer encode(boolean head, Byte obj) {
		ByteBuffer bb = ByteBuffer.allocate(1 + (head ? 2 : 0));
		if(head)
			bb.putShort(header);
		bb.put(obj);
		
		bb.flip();
		return bb;
	}

}
