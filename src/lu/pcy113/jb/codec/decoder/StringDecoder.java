package lu.pcy113.jb.codec.decoder;

import java.nio.ByteBuffer;

public class StringDecoder extends DefaultObjectDecoder<String> {

	public StringDecoder() {
		super(String.class);
	}

	public String decode(boolean head, ByteBuffer bb) {
		verifyHeader(head, bb);

		StringBuilder sb = new StringBuilder();
		
		int length = bb.getInt();
		//byte[] b = new byte[length*Character.BYTES];
		for(int i = 0; i < length; i++)
			sb.append(bb.getChar());
		
		return sb.toString();
	}

}
