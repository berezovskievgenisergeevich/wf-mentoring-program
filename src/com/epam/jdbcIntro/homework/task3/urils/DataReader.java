package com.epam.jdbcIntro.homework.task3.urils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

public class DataReader {

    private String namePath = "src\\com\\epam\\jdbcIntro\\homework\\task3\\data\\name.txt";
    private String lastNamePath = "src\\com\\epam\\jdbcIntro\\homework\\task3\\data\\last_name.txt";


    public List<String> getListNames() throws FileNotFoundException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(namePath));
        return bufferedReader.lines().collect(Collectors.toList());
    }

    public List<String> getListLastNames() throws FileNotFoundException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(lastNamePath));
        return bufferedReader.lines().collect(Collectors.toList());
    }
}
