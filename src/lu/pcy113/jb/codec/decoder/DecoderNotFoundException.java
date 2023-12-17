package lu.pcy113.jb.codec.decoder;

public class DecoderNotFoundException extends RuntimeException {

	public DecoderNotFoundException() {
	}

	public DecoderNotFoundException(short header) {
		super("No decoder found for header: " + header);
	}

}
