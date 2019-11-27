package com.epam.workingWithFiles.lectures;

import java.io.File;

public class FileDemo {
    public static void main(String[] args) {
        String filePath = "src\\com\\epam\\workingWithFiles\\lectures\\test_file.txt";
        String dirPath = "src\\com\\epam\\workingWithFiles\\lectures\\testDir";

        File file = new File(filePath);
        System.out.println(file.exists());
        System.out.println(file.length());


        File dir = new File(dirPath);
        System.out.println(dir.exists());
        if (dir.mkdir()) {
            System.out.println(dir.exists());
            System.out.println(dir.isDirectory());
        }

        String[] fileName = dir.list();

        File[] files = dir.listFiles();


    }
}
