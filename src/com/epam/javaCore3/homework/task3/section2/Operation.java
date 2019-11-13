package com.epam.javaCore3.homework.task3.section2;

@FunctionalInterface
public interface Operation<T> {
    /**
     * Takes 2 parameters of the same type T
     * <p>
     * performs an operation and returns a result of type T
     *
     * @param value1
     * @param value2
     * @return
     */
    T getResult(T value1, T value2);

    /**
     * Prints the specified line by adding 'Hello' to it
     * @param name
     */
    default void defaultPrintMethod(String name) {
        System.out.printf("Hello %s \n", name);
    }

    static void staticInfoPrinter() {
        System.out.println("This is some information from FunctionalInterface");
    }


}
