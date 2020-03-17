package com.epam.multithreading.example1;

import java.util.concurrent.Semaphore;

class IncThread extends MyThread {

    public IncThread(String name, Semaphore semaphore) {
        super(name, semaphore);
    }
}
