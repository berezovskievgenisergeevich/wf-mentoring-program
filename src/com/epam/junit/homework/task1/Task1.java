package com.epam.junit.homework.task1;

import java.text.Normalizer;

/**
 * Create class Utils with a few methods. Write tests to cover these methods. Use TDD approach.
 * <p>
 * 1. Write a test for concatenateWords method using AssertEquals.
 * <p>
 * 2. Create test method testComputeFactorial.
 * <p>
 * 3. Add method testFactorialWithTimeout, that calculates factorial of random number. Add possibility of timeout and interruption of thread if time for method execution will be exceeded
 * <p>
 * 4. Add method testExpectedException for calling computeFactorial with variable "-5". Add corresponding parameter to the annotation @Test for IllegalArgumentException raising when necessary as the result of test execution
 * <p>
 * 5. To disable test, add annotation @Ignore under the annotation @Test. Disable test method testNormalizeWord*.
 * <p>
 * 6. All the tests should contain necessary annotations (@BeforeClass, @Before, @After, @AfterClass)
 */
public class Task1 {
    public String concatenateWords(String s1, String s2) {
        return s1 + s2;
    }

    public int computeFactorial(int n) {
        if (n < 0)
            throw new IllegalArgumentException();
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result = result * i;
        }
        return result;

    }

    public String normalizeWord(CharSequence targetChars) {
        return Normalizer.normalize(targetChars, Normalizer.Form.NFD);

    }
}
