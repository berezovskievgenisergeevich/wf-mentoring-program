package com.epam.javaCore2.homework.ojectModelPublicTransport.customAnnotators;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * UseArrayList which could be attached to methods and couldn’t be found in the bytecode
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.CLASS)
public @interface UseArrayList {
}
