package com.epam.multithreading.example4;

public class BarAction implements Runnable {
    @Override
    public void run() {
        System.out.println("Барьер достигнут");
    }
}
