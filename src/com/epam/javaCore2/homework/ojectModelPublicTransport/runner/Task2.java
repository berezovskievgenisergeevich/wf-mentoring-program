package com.epam.javaCore2.homework.ojectModelPublicTransport.runner;

import com.epam.javaCore2.homework.ojectModelPublicTransport.models.transport.Bus;
import com.epam.javaCore2.homework.ojectModelPublicTransport.models.transport.PublicTransport;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {

        Bus bus = createNewInstance();

        setPrivateFields(bus);

        invokeMethodWithReflection(bus);

        analyzeClass(bus);
    }

    /**
     * Use reflection to instantiate all objects in client code via constructors
     *
     * @return
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws InstantiationException
     */
    private static Bus createNewInstance() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor constructor = Bus.class.getConstructor(String.class, String.class, String.class);
        Bus bus = (Bus) constructor.newInstance("name", "cost", "1");
        System.out.println(bus);
        return bus;

    }

    /**
     * Use reflection API to change method calls from direct call on reflection call in client code
     *
     * @param bus
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    private static void invokeMethodWithReflection(Bus bus) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = Bus.class.getMethod("move");
        method.invoke(bus);
    }

    /**
     * Use reflection API to fill private fields without setters
     *
     * @param bus
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    private static void setPrivateFields(Bus bus) throws NoSuchFieldException, IllegalAccessException {
        Field declaredField = PublicTransport.class.getDeclaredField("name");
        declaredField.setAccessible(true);
        declaredField.set(bus, "new Name");
        System.out.println(bus);

    }

    /**
     * Print out the metadata for all classes in application in human-readable format format (about all fields, methods, modifiers and etc.)     *
     *
     * @param o
     */
    private static void analyzeClass(Object o) {
        Class clazz = o.getClass();
        System.out.println("Class Name: " + clazz);
        System.out.println("Class Fields: " + Arrays.toString(clazz.getDeclaredFields()));
        System.out.println("Parent Class: " + clazz.getSuperclass());
        System.out.println("Class Methods: " + Arrays.toString(clazz.getDeclaredMethods()));
        System.out.println("Class Constructors: " + Arrays.toString(clazz.getConstructors()));
    }

}
