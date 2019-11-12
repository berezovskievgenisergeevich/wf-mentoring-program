package com.epam.javaCore2.homework.ojectModelPublicTransport.runner;

import com.epam.javaCore2.homework.ojectModelPublicTransport.customAnnotators.ThisCodeSmells;
import com.epam.javaCore2.homework.ojectModelPublicTransport.exceptions.NotUseSmellCodeException;
import com.epam.javaCore2.homework.ojectModelPublicTransport.models.utils.ParkManager;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Task4 {
    public static void main(String[] args) {



      /*  try {
            printAllSmellCode(ParkManager.class);
        } catch (NotUseSmellCodeException e) {
            e.printStackTrace();
        }*/
    }

    public static Class getClassUsingAnnotation(String className, Class annotation) throws ClassNotFoundException, NotUseSmellCodeException {
        Class cl = Class.forName(className);
        return getClassUsingAnnotation(cl, annotation);
    }

    public static Class getClassUsingAnnotation(Class cl, Class annotation) throws NotUseSmellCodeException {
        if (cl.isAnnotationPresent(annotation))
            return cl;
        throw new NotUseSmellCodeException("Class [" + cl.getName() + "] NOT USE " + annotation.getName() + " annotation");
    }

    public static List<Method> getMethodsUsingAnnotation(Class cl, Class annotation) throws NotUseSmellCodeException {
        List declaredNames = Arrays.stream(cl.getDeclaredMethods()).filter(method -> method.isAnnotationPresent(ThisCodeSmells.class)).collect(Collectors.toList());
        if (declaredNames.isEmpty())
            throw new NotUseSmellCodeException("Class [" + cl.getName() + "] NOT USE " + annotation.getName() + " method annotation");

        return declaredNames;
    }

    public static List<Field> getFieldsUsingAnnotation(Class cl, Class annotation) throws NotUseSmellCodeException {
        List declaredNames = Arrays.stream(cl.getDeclaredFields()).filter(field -> field.isAnnotationPresent(ThisCodeSmells.class)).collect(Collectors.toList());
        if (declaredNames.isEmpty())
            throw new NotUseSmellCodeException("Class [" + cl.getName() + "] NOT USE " + annotation.getName() + " field annotation");

        return declaredNames;
    }


    public static String getClassNameUsingAnnotation(Class cl, Class annotation) throws NotUseSmellCodeException {
        return getClassUsingAnnotation(cl, annotation).getName();
    }

    public static List<String> getMethodsNameUsingAnnotation(Class cl, Class annotation) throws NotUseSmellCodeException {
        return getMethodsUsingAnnotation(cl, annotation).stream().map(method -> method.getName()).collect(Collectors.toList());
    }

    public static List<String> getFieldsNameUsingAnnotation(Class cl, Class annotation) throws NotUseSmellCodeException {
        return getFieldsUsingAnnotation(cl, annotation).stream().map(field -> field.getName()).collect(Collectors.toList());
    }

    private static String getClassNameUsingSmellCode(Class cl) throws NotUseSmellCodeException {
        return getClassNameUsingAnnotation(cl, ThisCodeSmells.class);
    }

    private static List<String> getMethodsNameUsingSmellCode(Class cl) throws NotUseSmellCodeException {
        return getMethodsNameUsingAnnotation(cl, ThisCodeSmells.class);
    }

    private static List<String> getFieldsNameUsingSmellCode(Class cl) throws NotUseSmellCodeException {
        return getFieldsNameUsingAnnotation(cl, ThisCodeSmells.class);
    }

    public static void printAllSmellCode(Class cl) throws NotUseSmellCodeException {
        printClassSmellCode(cl);
        printMethodsUseSmellCode(cl);
        printFieldsUseSmellCode(cl);
    }

    private static void printClassSmellCode(Class cl) throws NotUseSmellCodeException {
        System.out.printf("Class [%s] use ThisCodeSmells annotation\n", getClassNameUsingSmellCode(cl));
    }

    private static void printMethodsUseSmellCode(Class cl) throws NotUseSmellCodeException {
        getMethodsNameUsingSmellCode(cl).forEach(method -> System.out.println("Method [" + method + "] use ThisCodeSmells annotation"));
    }

    private static void printFieldsUseSmellCode(Class cl) throws NotUseSmellCodeException {
        getFieldsNameUsingSmellCode(cl).forEach(field -> System.out.println("Field [" + field + "] use ThisCodeSmells annotation"));
    }
}
