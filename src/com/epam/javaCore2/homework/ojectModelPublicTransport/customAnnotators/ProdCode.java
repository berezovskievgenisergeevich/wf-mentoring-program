package com.epam.javaCore2.homework.ojectModelPublicTransport.customAnnotators;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ProdCode which could be attached to methods only and should be accessed in Runtime
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ProdCode {
}
