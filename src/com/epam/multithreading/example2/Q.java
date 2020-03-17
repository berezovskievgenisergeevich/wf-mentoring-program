package com.epam.multithreading.example2;

import java.util.concurrent.Semaphore;

public class Q {
    int n;
    static Semaphore semCon = new Semaphore(0);
    static Semaphore semProd = new Semaphore(1);

    void get() {
        try {
            semCon.acquire();
        } catch (InterruptedException e) {
            System.out.println("Перехвачено ислючение типа InterruptedException в методе Get");
        }
        System.out.println("Получено: " + n);
        semProd.release();
    }

    void put(int n) {
        try {
            semProd.acquire();
        } catch (InterruptedException e) {
            System.out.println("Перехвачено ислючение типа InterruptedException в методе Put");
        }
        this.n = n;
        System.out.println("Отправлено: " + n);
        semCon.release();

    }

}
