package com.epam.workingWithFiles.lectures.stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestSream {
    private static String filePath = "src\\com\\epam\\workingWithFiles\\lectures\\test_file.txt";
    private static String filePathOut = "src\\com\\epam\\workingWithFiles\\lectures\\test_file1.txt";

    public static void main(String[] args) throws IOException {
        FileInputStream in = null;
        FileOutputStream out = new FileOutputStream(filePathOut);
        out.write("Hello world Out".getBytes());

        in = new FileInputStream(filePath);
        int c = in.read();
        while (c != -1) {
            System.out.println(c);
            c = in.read();
        }
        in.close();
        out.close();

    }
}
