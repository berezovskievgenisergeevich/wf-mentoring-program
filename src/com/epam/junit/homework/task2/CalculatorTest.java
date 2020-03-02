package com.epam.junit.homework.task2;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void testAddition() {
        double x = 5;
        double y = 1000;
        int result = 1005;
        assertEquals(result, calculator.addition(x, y), 0.1);
    }

    @Test
    public void testAddition_withZero() {
        int x = 0;
        int result = 0;
        assertEquals(result, calculator.addition(x, x));
    }

    @Test
    public void testSubtraction() {
        double x = 5;
        double y = 1000;
        int result = -995;
        assertEquals(result, calculator.subtraction(x, y), 0.1);
    }

    @Test
    public void testSubtraction_withZero() {
        int x = 0;
        int result = 0;
        assertEquals(result, calculator.subtraction(x, x));
    }

    @Test
    public void multiplication() {
        double x = 1000000;
        double y = 3;
        double result = 3000000;
        assertEquals(result, calculator.multiplication(x, y), 0.1);
    }

    @Test
    public void testMultiplication_withZero() {
        int x = 1;
        int y = 0;
        int result = 0;
        assertEquals(result, calculator.multiplication(x, y));
    }

    @Test
    public void testDivision() {
        double x = 4;
        double y = 2;
        double result = 2;
        assertEquals(result, calculator.division(x, y), 0.1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivision_withIllegalArgumentException() throws IllegalArgumentException {
        int x = 1;
        int y = 0;
        calculator.division(x, y);

    }

    @Test
    public void testRoot() {
        double n = 25;
        double result = 5;
        assertEquals(result, calculator.root(n), 0.1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRoot_withIllegalArgumentException() throws IllegalArgumentException {
        int n = -1;
        calculator.root(n);
    }

    @Test
    public void testPow() {
        double number = 10;
        double n = 2;
        double result = 100;
        assertEquals(result, calculator.pow(number, n), 0.1);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testPow_withIllegalArgumentException() throws IllegalArgumentException {
        int number = 1;
        int n = 0;
        calculator.pow(number, n);
    }

    @Test
    public void fibonacci() {
        int n = 6;
        int result = 21;
        assertThat(calculator.fibonacci(n), equalTo(result));
    }
}