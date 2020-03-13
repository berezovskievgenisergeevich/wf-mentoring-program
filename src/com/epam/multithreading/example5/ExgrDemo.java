package com.epam.multithreading.example5;

import java.util.concurrent.Exchanger;

public class ExgrDemo {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        new MakeString(exchanger);
        new UseString(exchanger);


    }
}
