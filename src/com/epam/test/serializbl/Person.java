package com.epam.test.serializbl;

import java.io.Serializable;

public class Person implements Serializable {

    // Instance attributes.
    private String name;
    private int age;

    //  Constructors.
    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //  Getters.
    public String getName() {
        return this.name;
    }

    public String name() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public int age() {
        return this.age;
    }

    //  Setters.
    public void setName(String name) {
        this.name = name;
    }

    public void name(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void age(int age) {
        this.age = age;
    }

    //  Defining the textual representation of the objects of this class.
    public String toString() {
        return String.format("Name: %s, Age: %d", this.name, this.age);
    }
}
