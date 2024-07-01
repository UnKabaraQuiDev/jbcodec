package example.class_object;

import lu.pcy113.jbcodec.others.ObjectSerializable;
import lu.pcy113.jbcodec.others.ObjectSerializableInit;

public class SerializableObject implements ObjectSerializable {

	@ObjectSerializableInit
	public static SerializableObject init() {
		return new SerializableObject();
	}

}
