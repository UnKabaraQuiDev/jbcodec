package lu.pcy113.jbcodec.decoder;

import java.nio.ByteBuffer;

import lu.pcy113.jbcodec.CodecManager;

public interface Decoder<T> {

	short header();

	CodecManager codecManager();

	Class<?> type();

	String register(CodecManager cm, short header);

	default void verifyRegister() {
		if (codecManager() != null)
			throw new IllegalArgumentException("Cannot register Decoder to more than one CodecManager.");
	}

	T decode(boolean head, ByteBuffer bb);

	default void verifyHeader(boolean head, ByteBuffer bb) {
		if (head)
			Decoder.decoderNotCompatible(bb.getShort(), header());
	}

	static void decoderNotCompatible(short nheader, short header) throws DecoderNotCompatibleException {
		if (nheader != header)
			throw new DecoderNotCompatibleException(
					"Decoder not compatible with header: " + nheader + "; Header: " + header);
	}

}
