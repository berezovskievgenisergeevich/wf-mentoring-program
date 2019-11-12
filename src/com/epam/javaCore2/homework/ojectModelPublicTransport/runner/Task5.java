package com.epam.javaCore2.homework.ojectModelPublicTransport.runner;

import com.epam.javaCore2.homework.ojectModelPublicTransport.customAnnotators.ProdCode;
import com.epam.javaCore2.homework.ojectModelPublicTransport.exceptions.NotUseSmellCodeException;
import com.epam.javaCore2.homework.ojectModelPublicTransport.models.utils.ClassFinder;

public class Task5 {
    public static void main(String[] args) {

        /*Methods are using Prod code annotation:
         *  com.epam.javaCore2.homework.ojectModelPublicTransport.models.transport.Bus.move()
         *  com.epam.javaCore2.homework.ojectModelPublicTransport.models.utils.ClassWithProdCode.printHelloWorldProd();
         * */

        String searchPath = "com.epam.javaCore2.homework";
        Class searchAnnotation = ProdCode.class;

        ClassFinder.find(searchPath).stream()
                .forEach(findClass -> {
                    try {
                        Task4.getMethodsUsingAnnotation(findClass, searchAnnotation).forEach(method -> {
                            try {
                                Task2.invokeMethod(findClass, method.getName());
                            } catch (Exception e) {
                            }
                        });
                    } catch (NotUseSmellCodeException e) {
                    }
                });
    }
}

