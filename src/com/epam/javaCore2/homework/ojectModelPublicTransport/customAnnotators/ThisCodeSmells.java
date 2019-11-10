package com.epam.javaCore2.homework.ojectModelPublicTransport.customAnnotators;

/**
 * ThisCodeSmells(reviewer=”Petya”) which could be attached everywhere and could be repeatable
 */
public @interface ThisCodeSmells {
    String reviewer() default "Default Value";
}
