package com.epam.multithreading;

import java.util.concurrent.Semaphore;

public class SemDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        new IncThread("A", semaphore);
        new DecThread("B", semaphore);

    }
}

class Shared {
    static int count = 0;
}

class IncThread extends MyThread {

    public IncThread(String name, Semaphore semaphore) {
        super(name, semaphore);
    }
}

class DecThread extends MyThread {
    public DecThread(String name, Semaphore semaphore) {
        super(name, semaphore);
    }

    @Override
    public void getAccessToResource() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            Shared.count--;
            System.out.println(name + ": " + Shared.count);
            //разрешить, если возможно, переключение контекста
            Thread.sleep(10);
        }

    }
}


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
            System.out.println(name + ": " + Shared.count);
            //разрешить, если возможно, переключение контекста
            Thread.sleep(10);
        }
    }

}

interface MyThreadInt {
    void getAccessToResource() throws InterruptedException;
}