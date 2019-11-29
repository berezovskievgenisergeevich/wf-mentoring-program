package com.epam.workingWithFiles.lectures;

import com.epam.workingWithFiles.homework.task3.model.Play;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {

        //  countSLetterInWord();
        //   testEqualsUpperCase();
        testStringEqualsEnam();

    }

    private static void testStringEqualsEnam() {
        System.out.println("ACT".equals(Play.ACT.name()));
        System.out.println("ACT".equals(Play.ACT));
        System.out.println("ACT".equals(Play.ACT.toString()));
        System.out.println("ACT" == Play.ACT.toString());
    }

    private static void testEqualsUpperCase() {
        String testStr = "QWE";//"The Tragedy of Hamlet, Prince of Denmark";
        if (testStr.equals(testStr.toUpperCase()))
            System.out.println("AQQQQ");
    }

    private static void countSLetterInWord() {
        String text = "SomeFileNameWostwoS";
        Pattern pattern = Pattern.compile("([sS])");
        Matcher matcher = pattern.matcher(text);

        int count = 0;
        while (matcher.find()) {
            count++;
        }
        System.out.println(count);
    }
}
