package com.epam.multithreading.example9;

public class AtomThread implements Runnable {
    String name;

    public AtomThread(String name) {
        this.name = name;
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println("Запуск потока: " + name);
        for (int i = 0; i <= 3; i++) {
            System.out.println("Поток " + name + " получено: " + Shared.ai.getAndSet(i));

        }
    }
}
