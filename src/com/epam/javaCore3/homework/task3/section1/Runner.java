package com.epam.javaCore3.homework.task3.section1;


import java.util.function.*;

/**
 * Implement each of main Java Standard Library functional interfaces (supplier, predicate etc.) using lambda expressions.
 */
public class Runner {
    public static void main(String[] args) {
        squareLazy(generateLazyValue(5));
        System.out.println(isPositive(-10));
        System.out.println(multiply(3, 4));
        System.out.println(square(6));
        System.out.println(convertToDollar(100));
        namePrinter("Kirkovski");

    }


    /**
     * Supplier<T> takes no arguments, but must return an object of type T
     * <p>
     * In this example raises in the number of in 2 degree of
     * And displays a message
     *
     * @param lazyValue
     * @return
     */
    public static double squareLazy(Supplier<Double> lazyValue) {
        return Math.pow(lazyValue.get(), 2);
    }

    private static Supplier<Double> generateLazyValue(double number) {
        Supplier<Double> lazyValue = () -> {
            System.out.println("Generate lazy Value. Do Something");
            return number;
        };
        return lazyValue;
    }

    /**
     * The Predicate<T> functional interface verifies that a condition is met.
     * <p>
     * If it is true, it returns true. The lambda expression takes an object of type T as a parameter
     * <p>
     * This example shows whether the number is positive
     *
     * @param number
     * @return
     */
    public static boolean isPositive(int number) {
        Predicate<Integer> predicate = x -> x > 0;
        return predicate.test(number);

    }

    /**
     * Binary Operator<T> takes two objects of type T as a parameter,
     * <p>
     * performs a binary operation on them and returns its result as an object of type T
     * <p>
     * In this example 2 numbers are multiplied
     *
     * @param x
     * @param y
     * @return
     */
    public static int multiply(int x, int y) {
        BinaryOperator<Integer> operator = (var1, var2) -> var1 * var2;
        return operator.apply(x, y);
    }

    /**
     * Unary Operator<T> takes an object of type T as a parameter,
     * <p>
     * performs operations on them, and returns the result of operations as an object of type T
     *
     * @param x
     * @return
     */
    public static int square(int x) {
        UnaryOperator<Integer> operator = var -> var * var;
        return operator.apply(x);
    }

    /**
     * The function<T,R> interface represents a transition function from an object of type T to an object of type R
     *
     * @param number
     * @return
     */
    public static String convertToDollar(int number) {
        Function<Integer, String> function = x -> String.valueOf(x) + "$";
        return function.apply(number);
    }

    /**
     * Consumer<T> performs some action on an object of type T without returning anything
     */
    public static void namePrinter(String name) {
        Consumer<String> consumer = s -> System.out.printf("Hello %s !", s);
        consumer.accept(name);
    }


}
