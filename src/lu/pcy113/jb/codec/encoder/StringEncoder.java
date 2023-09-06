package lu.pcy113.jb.codec.encoder;

import java.nio.ByteBuffer;

public class StringEncoder extends DefaultObjectEncoder<String> {
	
	public StringEncoder() {
		super(String.class);
	}

	public ByteBuffer encode(boolean head, String obj) {
		ByteBuffer bb = ByteBuffer.allocate(obj.length() + 4 + (head ? 2 : 0));
		if(head)
			bb.putShort(header);
		bb.putInt(obj.length());
		bb.put(obj.getBytes());
		
		bb.flip();
		return bb;
	}

}
