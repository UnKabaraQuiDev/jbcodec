package lu.pcy113.jbcodec.others;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ObjectSerializableInit {
	
	boolean ignoreNoSuchMethod() default false;
	boolean ignoreExceptions() default false;
	
}
