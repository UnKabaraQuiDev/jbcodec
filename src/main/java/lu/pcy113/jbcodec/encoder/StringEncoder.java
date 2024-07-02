package lu.pcy113.jbcodec.encoder;

import java.nio.ByteBuffer;

public class StringEncoder extends DefaultObjectEncoder<String> {

	@Override
	public ByteBuffer encode(boolean head, String obj) {
		ByteBuffer bb = ByteBuffer.allocate(estimateSize(head, obj));
		super.putHeader(head, bb);
		
		bb.putInt(obj.length());

		for (char c : obj.toCharArray())
			bb.putChar(c);

		bb.flip();
		return bb;
	}

	@Override
	public int estimateSize(boolean head, String obj) {
		return obj.length() * Character.BYTES + Integer.BYTES + super.estimateHeaderSize(head);
	}

}
