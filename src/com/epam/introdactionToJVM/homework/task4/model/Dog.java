package com.epam.introdactionToJVM.homework.task4.model;

public class Dog implements Animal {
    @Override
    public void play() {
        System.out.println("Dog play");
    }

    @Override
    public void voice() {
        System.out.println("Dog voice - Vaf");
    }
}
