package com.epam.multithreading.example7;

import java.util.concurrent.Callable;

public class Sum implements Callable<Integer> {
    int stop;

    public Sum(int i) {
        stop = i;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i <= stop; i++) {
            sum += i;
        }
        return sum;
    }
}
