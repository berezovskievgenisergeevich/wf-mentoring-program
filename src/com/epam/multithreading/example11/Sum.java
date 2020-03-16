package com.epam.multithreading.example11;

import java.util.concurrent.RecursiveTask;

public class Sum extends RecursiveTask<Double> {
    final int seqThreadsHold = 500;
    double[] data;
    int start, end;

    public Sum(double[] data, int start, int end) {
        this.data = data;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Double compute() {
        double sum = 0;

        if ((end - start) < seqThreadsHold) {
            for (int i = start; i < end; i++) {
                sum += data[i];
            }
        } else {
            int middle = (start + end) / 2;
            Sum subTaskA = new Sum(data, start, middle);
            Sum subTaskB = new Sum(data, middle, end);

            subTaskA.fork();
            subTaskB.fork();

            sum = subTaskA.join() + subTaskB.join();
        }
        return sum;
    }
}
