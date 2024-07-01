package example.class_object;

import org.junit.jupiter.api.Test;

import lu.pcy113.jbcodec.CodecManager;
import lu.pcy113.jbcodec.decoder.ClassDecoder;
import lu.pcy113.jbcodec.decoder.ObjectSerializableDecoder;
import lu.pcy113.jbcodec.encoder.ClassEncoder;
import lu.pcy113.jbcodec.encoder.ObjectSerializableEncoder;
import lu.pcy113.pclib.PCUtils;

public class ObjectSerializableMain {

	@Test
	public void objectSerializableEncoderTest() {
		CodecManager cm = CodecManager.base();

		cm.register(new ClassEncoder(), new ClassDecoder(), (short) 20);
		cm.register(new ObjectSerializableEncoder(), new ObjectSerializableDecoder(), (short) 21);

		System.out.println("out: " + PCUtils.byteBufferToHexString(cm.encode(true, new SerializableObject())));

		System.out.println("decoded: " + cm.decode(cm.encode(true, new SerializableObject())).getClass());
	}

}
