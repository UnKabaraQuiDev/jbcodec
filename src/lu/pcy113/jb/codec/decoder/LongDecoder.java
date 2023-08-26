package lu.pcy113.jb.codec.decoder;

import java.nio.ByteBuffer;

import lu.pcy113.jb.codec.CodecManager;

public class LongDecoder implements Decoder<Long> {

	public CodecManager cm = null;
    public short header;

    public CodecManager codecManager() {return cm;}
    public short header() {return header;}
    public Class<?> type() {return Long.class;}
    
    public String register(CodecManager cm, short header) {
    	verifyRegister();
    	
        this.cm = cm;
        this.header = header;
        
        return type().getName();
    }

    public Long decode(boolean head, ByteBuffer bb) {
        if(head) {
            short nheader = bb.getShort();
            if(nheader != header)
                Decoder.decoderNotCompatible(nheader, header);
        }

        return bb.getLong();
    }
	
}
