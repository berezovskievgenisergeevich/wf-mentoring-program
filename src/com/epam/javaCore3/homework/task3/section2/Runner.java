package com.epam.javaCore3.homework.task3.section2;

/**
 * Task 3
 * Functional Interface Sandbox
 * <p>
 * 2. Create your own functional interface and add several implementations using both lambda expressions and inner anonymous classes.
 * <p>
 * 3. Add few default methods to it and use them.
 * <p>
 * 4. Add few static methods to it and use them.
 */
public class Runner {
    public static void main(String[] args) {

        /*  Implementation of functional interface using lambda*/
        Operation<Integer> addition = (value1, value2) -> value1 + value2;
        System.out.println(addition.getResult(1, 2));

        /*  Implementation of functional interface using lambda*/
        Operation<String> concatennation = (value1, value2) -> value1 + value2;
        System.out.println(concatennation.getResult("Jim ", "Carlos"));

        /*  Implementation of functional interface using inner anonymous classes*/
        Operation<Double> operation = new Operation<Double>() {
            @Override
            public Double getResult(Double value1, Double value2) {
                return value1 * value2;
            }
        };
        System.out.println(operation.getResult(5d, 5d));

        /*Add few default methods to functional interface and use them*/
        operation.defaultPrintMethod("Kiman Put");

        /*Add few static methods to functional interface and use them*/
        Operation.staticInfoPrinter();


    }
}
