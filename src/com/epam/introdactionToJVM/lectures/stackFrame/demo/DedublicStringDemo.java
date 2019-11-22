package com.epam.introdactionToJVM.lectures.stackFrame.demo;

import java.util.LinkedList;
import java.util.List;

public class DedublicStringDemo {
    private static final List<String> pool = new LinkedList<>();


    public static void main(String[] args) throws InterruptedException {
        int iteration = 0;
        while (true) {
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 1000; j++) {
                    pool.add(new String("String" + j));
                }

            }
            iteration++;
            System.out.println("Survived iteration " + iteration);
            Thread.sleep(100);
        }
    }
}
