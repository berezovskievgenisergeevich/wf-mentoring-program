package com.epam.workingWithFiles.lectures;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
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
