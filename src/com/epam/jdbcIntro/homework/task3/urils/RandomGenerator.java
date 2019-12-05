package com.epam.jdbcIntro.homework.task3.urils;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Random;

public class RandomGenerator {
    private static int MIN_DAY = 1;
    private static int MAX_DAY = 31;
    private static int MIN_MONTHS = 1;
    private static int MAX_MONTHS = 12;
    private static int MIN_YEAR = 1990;
    private static int MAX_YEAR = 2025;

    private static DataReader dataReader = new DataReader();
    private static List<String> names;
    private static List<String> lastNames;

    static {
        try {
            names = dataReader.getListNames();
            lastNames = dataReader.getListLastNames();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(generateName());
        System.out.println(generateLastName());
        System.out.println(generateBirthday());
    }


    public static String generateBirthday() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(getRandomDay()).append("-");
        buffer.append(getRandomMonth()).append("-");
        buffer.append(getRandomYear());
        return buffer.toString();
    }

    public static String generateName() {
       return names.get(getRandomNumberOfRange(0, names.size()));
    }
    public static String generateLastName() {
        return lastNames.get(getRandomNumberOfRange(0, lastNames.size())).trim();
    }


    private static int getRandomNumberOfRange(int min, int max) {
        Random rnd = new Random(System.currentTimeMillis());
        return min + rnd.nextInt(max - min + 1);
    }

    private static int getRandomDay() {
        return getRandomNumberOfRange(MIN_DAY, MAX_DAY);
    }

    private static int getRandomMonth() {
        return getRandomNumberOfRange(MIN_MONTHS, MAX_MONTHS);
    }

    private static int getRandomYear() {
        return getRandomNumberOfRange(MIN_YEAR, MAX_YEAR);
    }

}
