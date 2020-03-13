package com.epam.multithreading.example8;

import java.util.concurrent.locks.ReentrantLock;

public class LockThread implements Runnable {

    ReentrantLock lock;
    String name;

    public LockThread(ReentrantLock lock, String name) {
        this.lock = lock;
        this.name = name;
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println("Запуск потока " + name);
        try {
            System.out.println("Поток " + name + "  Ожидает блокировки");
            lock.lock();
            System.out.println("Поток " + name + " Блокирует счетчик");
            Shared.count++;
            System.out.println("Поток " + name + " :" + Shared.count);

            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Поток " + name + " Разблокирует счетчик");
            lock.unlock();
        }

    }
}
