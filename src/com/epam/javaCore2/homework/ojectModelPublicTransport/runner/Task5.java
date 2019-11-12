package com.epam.javaCore2.homework.ojectModelPublicTransport.runner;

import com.epam.javaCore2.homework.ojectModelPublicTransport.customAnnotators.ProdCode;
import com.epam.javaCore2.homework.ojectModelPublicTransport.customAnnotators.ThisCodeSmells;
import com.epam.javaCore2.homework.ojectModelPublicTransport.exceptions.NotUseSmellCodeException;
import com.epam.javaCore2.homework.ojectModelPublicTransport.models.utils.ClassFinder;
import com.epam.javaCore2.homework.ojectModelPublicTransport.models.utils.ClassWithProdCode;

public class Task5 {
    public static void main(String[] args) throws NotUseSmellCodeException {
        new ClassWithProdCode().printHelloWorldProd();
        Task4.getMethodsUsingAnnotation(ClassWithProdCode.class, ProdCode.class).forEach(System.out::println);

        ClassFinder.find("com.epam.javaCore2.homework.ojectModelPublicTransport.models.utils").stream()
                .forEach(aClass -> {
                    System.out.println(aClass);

                });



    }
}
