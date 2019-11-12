package com.epam.javaCore2.homework.ojectModelPublicTransport.customAnnotators;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Only which could be attached to fields and couldn’t be accessed in Runtime
 */
@Target(ElementType.FIELD)
public @interface UseStackOnly {
}
