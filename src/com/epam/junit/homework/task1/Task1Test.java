package com.epam.junit.homework.task1;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Task1Test {

    private Task1 task1;

    @Before
    public void setUp() {
        task1 = new Task1();
    }

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.out.println("BeforeClass");
    }

    @Test
    public void testConcatenateWords() {
        String s1 = "1";
        String s2 = "2";
        String result = s1 + s2;
        assertEquals(result, task1.concatenateWords(s1, s2));
    }

    @Test
    public void testComputeFactorial() {
        int n = 3;
        int result = 6;
        assertEquals(result, task1.computeFactorial(n));
    }

    @Test(timeout = 1)
    public void testFactorialWithTimeout() {
        int n = 15;
        int result = 2004310016;
        assertEquals(result, task1.computeFactorial(n));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExpectedException() throws IllegalArgumentException {
        int n = -5;
        task1.computeFactorial(n);
    }

    @Test
    @Ignore
    public void testNormalizeWord() {
        String s = "schön";
        String result = "schön";
        assertEquals(result, task1.normalizeWord(s));
    }

}