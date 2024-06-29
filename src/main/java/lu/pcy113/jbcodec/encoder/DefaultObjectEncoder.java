package lu.pcy113.jbcodec.encoder;

import lu.pcy113.jbcodec.CodecManager;

/**
 * Simplification of an Encoder<T>; this wont work with generic types (Arrays, etc)
 *
 * @param <T> the type this encoder will encode; has to be the same as passed into the constructor
 */
public abstract class DefaultObjectEncoder<T> implements Encoder<T> {

	protected CodecManager cm = null;
	protected short header;

	protected final Class<?> clazz;

	public DefaultObjectEncoder(Class<?> clazz) {
		this.clazz = clazz;
	}

	public CodecManager codecManager() {
		return cm;
	}

	public short header() {
		return header;
	}

	public Class<?> type() {
		return clazz;
	}

	public String register(CodecManager cm, short header) {
		verifyRegister();

		this.cm = cm;
		this.header = header;

		return type().getName();
	}
}
