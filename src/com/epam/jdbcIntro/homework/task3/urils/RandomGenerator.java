package com.epam.jdbcIntro.homework.task3.urils;

import java.util.List;
import java.util.Random;

import static com.epam.jdbcIntro.homework.task3.data.Info.*;

public class RandomGenerator {

    private static DataReader dataReader = new DataReader();
    private static List<String> names = dataReader.getListNames();
    private static List<String> lastNames = dataReader.getListLastNames();
    private static List<String> text = dataReader.getText();

    public static void main(String[] args) {

        System.out.println(generateText());
    }

    public static String generateText() {
        return text.get(getRandomNumberOfRange(0, text.size() - 1));
    }

    public static int generateRandomPostId() {
        return getRandomNumberOfRange(1, MAX_POST_COUNT);
    }

    public static String generateBirthday() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(getRandomDay()).append("-");
        buffer.append(getRandomMonth()).append("-");
        buffer.append(getRandomYear());
        return buffer.toString();
    }

    public static String generateName() {
        return names.get(getRandomNumberOfRange(0, names.size() - 1));
    }

    public static String generateLastName() {
        return lastNames.get(getRandomNumberOfRange(0, lastNames.size() - 1)).trim();
    }

    public static int getRandomUserId() {
        return getRandomNumberOfRange(MIN_USER_ID, MAX_USER_ID);
    }

    public static int getRandomUserId(int userId) {
        int id = getRandomNumberOfRange(MIN_USER_ID, MAX_USER_ID);
        if (userId == id)
            getRandomUserId(userId);
        return id;
    }

    public static String getRandomTimestamp() {
        return getRandomNumberOfRange(MIN_TIMESTAMP, MAX_TIMESTAMP) + "";
    }

    private static int getRandomNumberOfRange(int min, int max) {
        Random rnd = new Random(System.currentTimeMillis());
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
