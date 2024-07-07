package lu.pcy113.jbcodec.decoder;

import java.nio.ByteBuffer;
import java.util.ArrayList;

public class ArrayListDecoder extends DefaultObjectDecoder<ArrayList<?>> {

	public ArrayListDecoder() {
		super(ArrayList.class);
	}
	
	@Override
	public ArrayList<Object> decode(boolean head, ByteBuffer bb) {
		verifyHeader(head, bb);

		int length = bb.getInt();

		ArrayList<Object> array = new ArrayList<>();
		for (int i = 0; i < length; i++) {
			array.add(cm.decode(bb));
		}
		return array;
	}

}
