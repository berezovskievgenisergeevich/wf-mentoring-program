package com.epam.multithreading.example7;

import java.util.concurrent.Callable;

public class Hypot implements Callable<Double> {

    double sid1,sid2;

    public Hypot(double sid1, double sid2) {
        this.sid1 = sid1;
        this.sid2 = sid2;
    }

    @Override
    public Double call() throws Exception {
        return Math.sqrt((sid1*sid2) + (sid2*sid2));
    }
}
