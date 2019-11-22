package com.epam.introdactionToJVM.homework.task4.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class Invoker {
    public static void invokeCatAndDogMethods(List<Class> classes) throws ClassNotFoundException {
        /*Creator.createDogAndCat()*/classes.forEach(aClass -> {
            try {
                invokeMethodPlay(aClass);
                invokeMethodVoice(aClass);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private static void invokeMethodPlay(Class aClass) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        aClass.getMethod("play").invoke(aClass.newInstance());
    }

    private static void invokeMethodVoice(Class aClass) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        aClass.getMethod("voice").invoke(aClass.newInstance());
    }
}
