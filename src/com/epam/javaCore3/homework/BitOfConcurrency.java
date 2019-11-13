package com.epam.javaCore3.homework;

/**
 * Task 1. (5 points) A bit of concurrency
 * <p>
 * Create several instances of Runnable interface with different behavior using lambda expressions. Run these lambdas via Thread API.
 */
public class BitOfConcurrency {
    public static void main(String[] args) {
        threadStartFirstWay();
        threadStartSecondWay();
        threadStartThirdWay();

    }

    private static void threadStartFirstWay() {
        Runnable runnable = () -> System.out.println("Task #1 is running");
        Thread thread = new Thread(runnable);
        thread.start();
    }

    private static void threadStartSecondWay() {
        Thread thread = new Thread(() -> {
            System.out.println("Task #2 is running");
        });
        thread.start();
    }

    private static void threadStartThirdWay() {
        new Thread(() -> System.out.println("Task #3 is running")).start();
    }
}
