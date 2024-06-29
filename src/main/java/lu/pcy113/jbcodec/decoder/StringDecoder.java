package lu.pcy113.jbcodec.decoder;

import java.nio.ByteBuffer;

public class StringDecoder extends DefaultObjectDecoder<String> {

	@Override
	public String decode(boolean head, ByteBuffer bb) {
		verifyHeader(head, bb);

		StringBuilder sb = new StringBuilder();
		
		int length = bb.getInt();
		
		for(int i = 0; i < length; i++)
			sb.append(bb.getChar());
		
		return sb.toString();
	}

}
