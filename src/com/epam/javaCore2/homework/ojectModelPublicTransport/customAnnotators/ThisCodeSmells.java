package com.epam.javaCore2.homework.ojectModelPublicTransport.customAnnotators;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * ThisCodeSmells(reviewer=”Petya”) which could be attached everywhere and could be repeatable
 */
@Retention(RetentionPolicy.RUNTIME)

public @interface ThisCodeSmells {
    String reviewer() default "Default Value";
}
