package com.epam.jdbcIntro.lectures;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
    public static void main(String[] args) {
        String data = "CREATE PROCEDURE test_print()";

        getProcedureName(data);

    }

    private static String getProcedureName(String data) {
        Pattern pattern = Pattern.compile("(\\w*)[(]");
        Matcher matcher = pattern.matcher(data);
        matcher.find();
        return matcher.group(1);
    }
}
