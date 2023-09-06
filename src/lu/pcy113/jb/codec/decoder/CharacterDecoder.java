package lu.pcy113.jb.codec.decoder;

import java.nio.ByteBuffer;

public class CharacterDecoder extends DefaultObjectDecoder<Character> {
	
	public CharacterDecoder() {
		super(Character.class);
	}

    public Character decode(boolean head, ByteBuffer bb) {
        if(head) {
            short nheader = bb.getShort();
            if(nheader != header)
            	Decoder.decoderNotCompatible(nheader, header);
        }

        return bb.getChar();
    }

}
