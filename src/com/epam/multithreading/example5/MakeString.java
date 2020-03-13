package com.epam.multithreading.example5;

import java.util.concurrent.Exchanger;

public class MakeString implements Runnable {
    Exchanger<String> exchanger;
    String string;

    public MakeString(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
        string = new String();
        new Thread(this).start();
    }

    @Override
    public void run() {
        char ch = 'A';
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++)
                string += (char) ch++;
            try {
                string = exchanger.exchange(string);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
