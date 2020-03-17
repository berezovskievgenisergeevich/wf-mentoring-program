package com.epam.multithreading.example7;

import java.util.concurrent.Callable;

public class Factorial implements Callable<Integer> {
    int stop;

    public Factorial(int i) {
        stop = i;
    }

    @Override
    public Integer call() throws Exception {
        int fact = 1;
        for (int i = 1; i <= stop; i++) {
            fact *= i;
        }
        return fact;
    }
}
