package com.epam.multithreading.example1;

import java.util.concurrent.Semaphore;

class MyThread implements Runnable, MyThreadInt {
    String name;
    Semaphore semaphore;

    public MyThread(String name, Semaphore semaphore) {
        this.name = name;
        this.semaphore = semaphore;
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println("Запуск потока " + name);
        try {
            System.out.println("Поток " + name + " Ожидает разрешения");
            semaphore.acquire();
            System.out.println("Поток " + name + " получил разрешение");
            getAccessToResource();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Поток " + name + " освобождает разрешение");
        semaphore.release();
    }

    public void getAccessToResource() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            Shared.count++;
            utilPrintNameAndSleep();
        }
    }

    public void utilPrintNameAndSleep() throws InterruptedException {
        System.out.println(name + ": " + Shared.count);
        //разрешить, если возможно, переключение контекста
        Thread.sleep(10);
    }


}
