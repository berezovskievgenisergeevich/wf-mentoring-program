package com.epam.javaCore3.homework.task2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Create:
 *
 * 1. Person class with name and age fields
 *
 * 2. A collection of Persons;
 *
 * 3. Two instances of Comparator<Person> interface using lambda expressions: first one for comparing by name, second one – by age
 *
 * Then sort them using these comparators.
 *
 * Use forEach method for printing information about all the persons.
 *
 * Try to use method reference if it is possible.
 */
public class Runner {
    public static void main(String[] args) {
        ArrayList<Person> list = PersonCreator.createListPersons(5);
        list.forEach(System.out::println);

        sortByName(list);
        sortByAge(list);
    }

    private static void sortByName(List<Person> list) {
        Comparator<Person> byName =
                (Person o2, Person o1) -> o1.getName().compareTo(o2.getName());
        list.sort(byName);
        System.out.println("After Sorted by Name:");
        list.forEach(System.out::println);

    }

    private static void sortByAge(List<Person> list) {
        list.sort((person1, person2) -> person1.getAge() - person2.getAge());
        System.out.println("After Sorted by Name:");
    }

}
