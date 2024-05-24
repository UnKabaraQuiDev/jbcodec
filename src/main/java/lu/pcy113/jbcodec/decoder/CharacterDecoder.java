package lu.pcy113.jbcodec.decoder;

import java.nio.ByteBuffer;

public class CharacterDecoder extends DefaultObjectDecoder<Character> {

	public CharacterDecoder() {
		super(Character.class);
	}

	public Character decode(boolean head, ByteBuffer bb) {
		verifyHeader(head, bb);

		return bb.getChar();
	}

}
