package lu.pcy113.jb.codec.encoder;

import java.nio.ByteBuffer;

public class CharacterEncoder extends DefaultObjectEncoder<Character> {

	public CharacterEncoder() {
		super(Character.class);
	}

	public ByteBuffer encode(boolean head, Character obj) {
		ByteBuffer bb = ByteBuffer.allocate(1 + (head ? 2 : 0));
		if (head)
			bb.putShort(header);
		bb.putChar(obj);

		bb.flip();
		return bb;
	}

}
