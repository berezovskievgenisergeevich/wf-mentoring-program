package com.epam.introdactionToJVM.homework.task5;

import java.util.LinkedList;
import java.util.List;

/**
 * String Deduplication
 *
 * Run your pet/project application with enabled and disabled String Deduplication feature.
 *
 * Analyze stat info to say final word to use or not to use this feature on your project. Discuss it with mentor.
 *
 *
 * OPTIONS:
 * -XX:+UseG1GC
 * -XX:+UseStringDeduplication
 * -XX:+PrintStringDeduplicationStatistics
 */
public class DeduplicationStringDemo {
    private static final List<String> pool = new LinkedList<>();

    public static void main(String[] args) throws InterruptedException {
        int iteration = 0;
        while (true) {
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 1000; j++) {
                    pool.add("String" + j);
                }
            }
            iteration++;
            System.out.println("Survived iteration " + iteration);
            Thread.sleep(100);
        }
    }
}
