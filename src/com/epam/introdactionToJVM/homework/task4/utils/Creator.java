package com.epam.introdactionToJVM.homework.task4.utils;

import com.epam.introdactionToJVM.homework.task4.loader.MyClassLoader;

import java.util.ArrayList;
import java.util.List;

public class Creator {

    public static List<Class> createDogAndCat() throws ClassNotFoundException {
        List<Class> animals = new ArrayList<>();
        animals.add(createClassCat());
        animals.add(createClassDog());
        return animals;
    }

    private static Class createClassCat() throws ClassNotFoundException {
        return new MyClassLoader().findClass(ProjectInfo.CAT_CLASS_PATH);
    }

    private static Class createClassDog() throws ClassNotFoundException {
        return new MyClassLoader().findClass(ProjectInfo.DOG_CLASS_PATH);
    }


}
