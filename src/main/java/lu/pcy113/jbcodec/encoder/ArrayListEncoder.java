package lu.pcy113.jbcodec.encoder;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

import lu.pcy113.pclib.PCUtils;

public class ArrayListEncoder extends DefaultObjectEncoder<ArrayList<?>> {

	public ArrayListEncoder() {
		super(ArrayList.class);
	}

	/**
	 * ( HEAD 2b - SIZE 4b - SUB HEAD 2b - DATA xb
	 */
	public ByteBuffer encode(boolean head, ArrayList<?> obj) {
		List<Byte> elements = new ArrayList<>();
		for (Object o : obj) {
			elements.addAll(PCUtils.byteArrayToList(cm.encode(true, o).array()));
		}
		ByteBuffer bb = ByteBuffer.allocate((head ? 2 : 0) + 4 + elements.size());
		if (head)
			bb.putShort(header);
		bb.putInt(obj.size());
		bb.put(PCUtils.byteListToPrimitive(elements));

		bb.flip();
		return bb;
	}

}
