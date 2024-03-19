package lu.pcy113.jb.codec.encoder;

import java.nio.ByteBuffer;

import lu.pcy113.jb.codec.CodecManager;

public class StringEncoder extends DefaultObjectEncoder<String> {

	public StringEncoder() {
		super(String.class);
	}

	public ByteBuffer encode(boolean head, String obj) {
		ByteBuffer bb = ByteBuffer.allocate(estimateSize(head, obj));
		if (head)
			bb.putShort(header);
		bb.putInt(obj.length());
		
		for(char c : obj.toCharArray())
			bb.putChar(c);

		bb.flip();
		return bb;
	}
	
	@Override
	public int estimateSize(boolean head, String obj) {
		return obj.length()*Character.BYTES + Integer.BYTES + (head ? CodecManager.HEAD_SIZE : 0);
	}

}
