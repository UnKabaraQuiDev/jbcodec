package lu.pcy113.jb.codec;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map.Entry;

import lu.pcy113.jb.codec.decoder.ArrayDecoder;
import lu.pcy113.jb.codec.decoder.BooleanDecoder;
import lu.pcy113.jb.codec.decoder.ByteDecoder;
import lu.pcy113.jb.codec.decoder.CharacterDecoder;
import lu.pcy113.jb.codec.decoder.Decoder;
import lu.pcy113.jb.codec.decoder.DoubleDecoder;
import lu.pcy113.jb.codec.decoder.FloatDecoder;
import lu.pcy113.jb.codec.decoder.IntegerDecoder;
import lu.pcy113.jb.codec.decoder.LongDecoder;
import lu.pcy113.jb.codec.decoder.MapDecoder;
import lu.pcy113.jb.codec.decoder.NullDecoder;
import lu.pcy113.jb.codec.decoder.ShortDecoder;
import lu.pcy113.jb.codec.decoder.StringDecoder;
import lu.pcy113.jb.codec.decoder.VoidDecoder;
import lu.pcy113.jb.codec.encoder.ArrayEncoder;
import lu.pcy113.jb.codec.encoder.BooleanEncoder;
import lu.pcy113.jb.codec.encoder.ByteEncoder;
import lu.pcy113.jb.codec.encoder.CharacterEncoder;
import lu.pcy113.jb.codec.encoder.DoubleEncoder;
import lu.pcy113.jb.codec.encoder.Encoder;
import lu.pcy113.jb.codec.encoder.EncoderNotFoundException;
import lu.pcy113.jb.codec.encoder.FloatEncoder;
import lu.pcy113.jb.codec.encoder.IntegerEncoder;
import lu.pcy113.jb.codec.encoder.LongEncoder;
import lu.pcy113.jb.codec.encoder.MapEncoder;
import lu.pcy113.jb.codec.encoder.NullEncoder;
import lu.pcy113.jb.codec.encoder.ShortEncoder;
import lu.pcy113.jb.codec.encoder.StringEncoder;
import lu.pcy113.jb.codec.encoder.VoidEncoder;
import lu.pcy113.jb.codec.utils.Pair;

public class CodecManager {

    private HashMap<Short, Pair<Decoder, String>> registeredDecoders = new HashMap<>();
    private HashMap<String, Pair<Encoder, Short>> registeredEncoders = new HashMap<>();

    public void register(Decoder d, short header) {
    	registeredDecoders.put(header, new Pair<>(d, d.register(this, header)));
    }
    public void register(Encoder e, short header) {
    	registeredEncoders.put(e.register(this, header), new Pair<>(e, header));
    }
    public void register(Encoder e, Decoder d, short header) {
    	register(d, header);
    	register(e, header);
    }

    public Decoder getDecoder(short header) {
        return registeredDecoders.get(header).getKey();
    }
    public Encoder getEncoder(String name) {
        return registeredEncoders.get(name).getKey();
    }
    public Encoder getEncoder(Object clazz) {
    	try {
	    	String name = clazz.getClass().getName().replace("^class\\s", "");
	        if(registeredEncoders.containsKey(name))
	        	return registeredEncoders.get(name).getKey();
    	}catch(Exception e) {}
    	
        for(Entry<String, Pair<Encoder, Short>> e : registeredEncoders.entrySet())
        	if(e.getValue().getKey().confirmType(clazz))
        		return e.getValue().getKey();
        
        return null;
    }
    
    public ByteBuffer encode(Object o) {
    	Encoder e = getEncoder(o);
    	if(e == null)
    		throw new EncoderNotFoundException("Encoder for: "+o.getClass()+"; not registered in CodecManager.");
    	return e.encode(true, o);
    }
    public ByteBuffer encode(boolean b, Object o) {
    	Encoder e = getEncoder(o);
    	if(e == null)
    		throw new EncoderNotFoundException("Encoder for: "+o.getClass()+"; not registered in CodecManager.");
    	return e.encode(b, o);
    }
    public Object decode(ByteBuffer bb) {
    	return getDecoder(bb.getShort()).decode(false, bb);
    }
    
    /**
     * Registers the following D/Encoders:
     * 0. Null
     * 1. Byte
     * 2. Short
     * 3. Integer
     * 4. Double
     * 5. Float
     * 6. Long
     * 7. Character
     * 8. String
     * 9. Void
     * 10. Boolean
     * @return
     */
    public static final CodecManager base() {
    	CodecManager cm = new CodecManager();
    	
    	cm.register(new NullEncoder(), new NullDecoder(), (short) 0);
    	cm.register(new ByteEncoder(), new ByteDecoder(), (short) 1);
    	cm.register(new ShortEncoder(), new ShortDecoder(), (short) 2);
    	cm.register(new IntegerEncoder(), new IntegerDecoder(), (short) 3);
    	cm.register(new DoubleEncoder(), new DoubleDecoder(), (short) 4);
    	cm.register(new FloatEncoder(), new FloatDecoder(), (short) 5);
    	cm.register(new LongEncoder(), new LongDecoder(), (short) 6);
    	cm.register(new CharacterEncoder(), new CharacterDecoder(), (short) 7);
    	cm.register(new StringEncoder(), new StringDecoder(), (short) 8);
    	cm.register(new VoidEncoder(), new VoidDecoder(), (short) 9);
    	cm.register(new BooleanEncoder(), new BooleanDecoder(), (short) 10);
    	
    	return cm;
    }

}