package lu.pcy113.jb.utils;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public final class ArrayUtils {

	public static final ArrayList<Byte> byteArrayToList(byte[] b) {
		ArrayList<Byte> al = new ArrayList<>(b.length);
		for (int i = 0; i < b.length; i++)
			al.add(b[i]);
		return al;
	}

	public static final byte[] byteListToPrimitive(List<Byte> bytes) {
		byte[] b = new byte[bytes.size()];
		for (int i = 0; i < b.length; i++)
			b[i] = bytes.get(i);
		return b;
	}

	public static String byteArrayToHexString(byte[] byteArray) {
		StringBuilder sb = new StringBuilder();
		for (byte b : byteArray) {
			sb.append(String.format("%02X ", b));
		}
		return sb.toString();
	}

	public static String byteBufferToHexString(ByteBuffer bb) {
		int x = bb.position();
		StringBuilder sb = new StringBuilder();
		while (bb.hasRemaining()) {
			sb.append(String.format("%02X ", bb.get()));
		}
		bb.position(x);
		return sb.toString();
	}

	public static int byteToInt(byte[] byteArray) {
		if(byteArray.length != 4) {
			throw new NumberFormatException("Array length should be 4.");
		}
		
		int result = 0;
		for (int i = 0; i < byteArray.length; i++) {
			result = (result << 8) | (byteArray[i] & 0xFF);
		}
		
		return result;
	}

	public static byte[] byteBufferToArray(ByteBuffer bb) {
		int length = bb.remaining();
		byte[] cc = new byte[length];
		
		bb.get(cc);
		
		return cc;
	}

}
