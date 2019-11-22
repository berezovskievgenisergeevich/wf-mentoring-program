package com.epam.introdactionToJVM.homework.task4.model;

public class Cat implements Animal {
    @Override
    public void play() {
        System.out.println("Cat play");
    }

    @Override
    public void voice() {
        System.out.println("Cat voice - MIAO");
    }
}
