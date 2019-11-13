package com.epam.javaCore3.homework.task4;

/**
 * Task 4.
 * Custom Functional Interface
 *
 * 1. Write your own functional interface ThreeFunction (it takes three arguments and produce result).
 *
 * 2. Implement this with two different lambdas
 */
public class Runner {
    public static void main(String[] args) {
        ThreeFunction<Integer> cubeArea = (var1, var2, var3) -> var1 * var2 * var3;
        System.out.println(cubeArea.operatin(2, 3, 4));

        ThreeFunction<String> concatenation = (var1, var2, var3) ->
                new StringBuffer(var1).append(" ").append(var2).append(" ").append(var3).toString();
        System.out.println(concatenation.operatin("Hello", "Name", "Son"));
    }
}
