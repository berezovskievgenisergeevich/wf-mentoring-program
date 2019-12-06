package com.epam.jdbcIntro.homework.task3.urils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.epam.jdbcIntro.homework.task3.data.Info.*;

public class DataReader {

    public List<String> getListNames() {
        return getDataFromFile(NAMES_PATH);
    }

    public List<String> getListLastNames() {
        return getDataFromFile(LAST_NAMES_PATH);
    }
    public List<String> getText() {
        return getDataFromFile(TEXT_PATH);
    }

    private List<String> getDataFromFile(String filePath) {
        List<String> strings = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            strings = bufferedReader.lines().collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strings;
    }
}
