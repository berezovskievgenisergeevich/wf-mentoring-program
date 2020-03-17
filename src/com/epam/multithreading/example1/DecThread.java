package com.epam.multithreading.example1;

import java.util.concurrent.Semaphore;

class DecThread extends MyThread {
    public DecThread(String name, Semaphore semaphore) {
        super(name, semaphore);
    }

    @Override
    public void getAccessToResource() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            Shared.count--;
            utilPrintNameAndSleep();
        }

    }
}
