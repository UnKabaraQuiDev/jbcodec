package lu.pcy113.jb.codec.encoder;

import java.nio.ByteBuffer;

import lu.pcy113.jb.codec.CodecManager;

public class VoidEncoder implements Encoder<Void> {

	public CodecManager cm = null;
    public short header;

    public CodecManager codecManager() {return cm;}
    public short header() {return header;}
    public Class<?> type() {return Void.class;}
    
    public String register(CodecManager cm, short header) {
    	verifyRegister();
    	
        this.cm = cm;
        this.header = header;
        
        return type().getName();
    }
    
    public ByteBuffer encode(boolean head, Void obj) {
        ByteBuffer bb = ByteBuffer.allocate((head ? 2 : 0));
        if(head)
            bb.putShort(header);
        
        bb.flip();
        return bb;
    }

}
