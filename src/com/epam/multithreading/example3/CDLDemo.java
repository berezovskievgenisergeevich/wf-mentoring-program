package com.epam.multithreading.example3;

import java.util.concurrent.CountDownLatch;

public class CDLDemo {
    public static void main(String[] args) {
        // после 5 итераций(вызова latch.countDown()) поток завершиться. но цикл доработает в другом потоке(если количество итерраций не равно)
        //По завершении пятого шага цикла самоблокировка снимается, позволяя возобно­
        //вить главный поток исполнения.
        CountDownLatch cdl = new CountDownLatch(5);
        System.out.println("Запуск потока исполнения");

        new MyThread(cdl);
        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Завершения потока исполнпния");
    }
}
