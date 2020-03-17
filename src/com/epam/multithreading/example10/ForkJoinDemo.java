package com.epam.multithreading.example10;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinDemo {
    public static void main(String[] args) {
        ForkJoinPool fjp = new ForkJoinPool();
        double[] nums = new double[100000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (double) i;
        }
        System.out.println("Исходная последовательность (часть)");
        Arrays.stream(nums).filter(it -> it < 10).forEach(System.out::println);
        SqrtTransform task = new SqrtTransform(nums, 0, nums.length);
        fjp.invoke(task);

        System.out.println("Полученная последовательность (часть)");
        Arrays.stream(nums).filter(it -> it < 5).forEach(System.out::println);


    }
}
