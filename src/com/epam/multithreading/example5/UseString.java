package com.epam.multithreading.example5;

import java.util.concurrent.Exchanger;

public class UseString implements Runnable {
    Exchanger<String> exchanger;
    String string;

    public UseString(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
        new Thread(this).start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                string = exchanger.exchange(new String());
                System.out.println("Получено: " + string);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
