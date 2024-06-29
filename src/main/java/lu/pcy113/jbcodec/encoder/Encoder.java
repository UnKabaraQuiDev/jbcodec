package lu.pcy113.jbcodec.encoder;

import java.nio.ByteBuffer;

import lu.pcy113.jbcodec.CodecManager;

public interface Encoder<T> {

	CodecManager codecManager();

	short header();

	Class<?> type();

	String register(CodecManager cm, short header);

	default void verifyRegister() {
		if (codecManager() != null)
			throw new IllegalArgumentException("Cannot register Encoder to more than one CodecManager.");
	}

	ByteBuffer encode(boolean head, T obj);

	default int estimateSize(boolean head, T obj) {
		throw new UnsupportedOperationException("This method wasn't implements by: " + this.getClass().getName());
	}

	default boolean confirmType(Object obj) {
		return obj != null && obj.getClass().equals(type());
	}

	default boolean confirmClassType(Class<?> clazz) {
		return clazz != null && clazz.equals(type());
	}
}
