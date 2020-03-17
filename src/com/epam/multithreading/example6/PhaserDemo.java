package com.epam.multithreading.example6;

import java.util.concurrent.Phaser;

public class PhaserDemo {
    public static void main(String[] args) {

        Phaser phaser = new Phaser(1);

        System.out.println("Запуск потоков");
        new MyThread(phaser, "A");
        new MyThread(phaser, "B");
        new MyThread(phaser, "C");

        waitForAllExecutionThreadsCompletePhase(phaser);
        waitForAllExecutionThreadsCompletePhase(phaser);
        waitForAllExecutionThreadsCompletePhase(phaser);

        //снять основной поток с регистрации
        phaser.arriveAndDeregister();

        if (phaser.isTerminated())
            System.out.println("Синхронезатор фаз завершон");

    }

    public static void waitForAllExecutionThreadsCompletePhase(Phaser phaser) {
        int curPhase;
        curPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза "+curPhase+ " Завершена");
    }
}
