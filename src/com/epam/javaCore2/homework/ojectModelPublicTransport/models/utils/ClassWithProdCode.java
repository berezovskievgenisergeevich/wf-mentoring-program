package com.epam.javaCore2.homework.ojectModelPublicTransport.models.utils;

import com.epam.javaCore2.homework.ojectModelPublicTransport.customAnnotators.ProdCode;

public class ClassWithProdCode {
    @ProdCode
    public void printHelloWorldProd() {
        System.out.println("Hello world");
    }

}
