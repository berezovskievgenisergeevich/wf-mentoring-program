package com.epam.javaCore2.homework.ojectModelPublicTransport.runner;

import com.epam.javaCore2.homework.ojectModelPublicTransport.customAnnotators.ThisCodeSmells;
import com.epam.javaCore2.homework.ojectModelPublicTransport.models.utils.ParkManager;

import java.lang.reflect.Field;
import java.lang.reflect.Method;


public class Task4 {
    public static void main(String[] args) {

        printAllSmellCode(ParkManager.class);
    }

    private static void printAllSmellCode(Class cl) {
        printClassSmellCode(cl);
        printMethodsUseSmellCode(cl);
        printFieldsUseSmellCode(cl);
    }

    private static void printClassSmellCode(Class cl) {
        if (cl.isAnnotationPresent(ThisCodeSmells.class))
            System.out.printf("Class [%s] use ThisCodeSmells annotation\n", cl.getName());
        else
            System.out.printf("Class [%s] NOT USE ThisCodeSmells annotation\n", cl.getName());
    }

    private static void printMethodsUseSmellCode(Class cl) {
        for (Method method : cl.getDeclaredMethods()) {
            if (method.isAnnotationPresent(ThisCodeSmells.class))
                System.out.printf("Method [%s] use ThisCodeSmells annotation\n", method.getName());
        }
    }

    private static void printFieldsUseSmellCode(Class cl) {
        for (Field field : cl.getFields()) {
            if (field.isAnnotationPresent(ThisCodeSmells.class))
                System.out.printf("Field [%s] use ThisCodeSmells annotation\n", field.getName());
        }

    }
}
