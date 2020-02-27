package com.epam.junit.homework.task2;

/**
 * Task 2. Test your crazy calculator
 * <p>
 * Implement Calculator class and cover its methods with JUnit tests with both positive and negative scenarios. Group negative and positive tests cases into separate test suites.
 * <p>
 * Add following functionality:
 * <p>
 * 1. Addition, subtraction, multiplication, division, root/power function for int and double values.
 * <p>
 * 2. Division, root/power should check parameters and throw IllegalArgumentException (division by zero etc.).
 * <p>
 * 3. isPrime function and design test parameters for negative timeout scenario.
 * <p>
 * 4. Fibonacci sequence function. Use Java Hamcrest matchers to validate result.
 * <p>
 * 5. Handle all edge cases.
 * <p>
 * You should follow TDD approach: red - green – refactor
 */
public class Calculator {

    public double addition(double x, double y) {
        return x + y;
    }

    public int addition(int x, int y) {
        return (int) addition(x * 1.0, y * 1.0);
    }

    public double subtraction(double x, double y) {
        return x - y;
    }

    public int subtraction(int x, int y) {
        return (int) subtraction(x * 1.0, y * 1.0);
    }

    public double multiplication(double x, double y) {
        return x * y;
    }

    public int multiplication(int x, int y) {
        return (int) multiplication(x * 1.0, y * 1.0);
    }

    public double division(double x, double y) {
        if (y == 0)
            throw new IllegalArgumentException("division by zero");
        return x / y;
    }

    public int division(int x, int y) {
        return (int) division(x * 1.0, y * 1.0);
    }

    public double root(double n) {
        if (n <= 0)
            throw new IllegalArgumentException("number should be > 0 ");
        return Math.sqrt(n);
    }

    public int root(int n) {
        return (int) root(n * 1.0);
    }

    public double pow(double number, double n) {
        if (n <= 0)
            throw new IllegalArgumentException("n should be > 0 ");
        return Math.pow(number, n);
    }

    public int pow(double number, int n) {
        return (int) pow(number, n * 1.0);
    }

    public int fibonacci(int n) {
        int a = 1;
        int b = 1;
        int sum_fib = 0;
        for (int i = 0; i < n; i++) {
            sum_fib = a + b;
            a = b;
            b = sum_fib;
        }
        return sum_fib;
    }

}
