package lu.pcy113.jb.codec.encoder;

import java.nio.ByteBuffer;

import lu.pcy113.jb.codec.CodecManager;

public class BooleanEncoder implements Encoder<Boolean> {

	public CodecManager cm = null;
    public short header;

    public CodecManager codecManager() {return cm;}
    public short header() {return header;}
    public Class<?> type() {return Boolean.class;}
    
    public String register(CodecManager cm, short header) {
    	verifyRegister();
    	
        this.cm = cm;
        this.header = header;
        
        return type().getName();
    }

    public ByteBuffer encode(boolean head, Boolean obj) {
        ByteBuffer bb = ByteBuffer.allocate(1 + (head ? 2 : 0));
        if(head)
            bb.putShort(header);
        bb.put((byte) (obj ? 1 : 0));
        
        bb.flip();
        return bb;
    }
	
}
