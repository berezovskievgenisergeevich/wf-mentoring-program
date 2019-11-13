package com.epam.javaCore3.homework.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PersonCreator {
    public static ArrayList<Person> createListPersons(int count) {

        ArrayList<Person> list = new ArrayList();
        for (int i = 0; i < count; i++) {
            list.add(new Person(generateName(i), i));
        }
        return list;
    }

    private static String generateName(int number) {
        return "Name " + number;
    }

    private static int generateAge(int number) {

        return new Random().nextInt(10) + number;
    }
}
