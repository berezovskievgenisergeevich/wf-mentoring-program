package com.epam.workingWithFiles.lectures.fileReader;

import java.io.*;

public class FileReaderDemo {
    private static String filePath = "src\\com\\epam\\workingWithFiles\\lectures\\test_file.txt";
    private static String filePathOut = "src\\com\\epam\\workingWithFiles\\lectures\\test_file1.txt";

    public static void main(String[] args) throws IOException {
        Writer writer = new FileWriter(filePathOut);
        writer.write("EEEEEE");
        writer.close();


        Reader reader = new FileReader(filePath);
        int data = reader.read();
        while (data!=-1){
            char dataChar = (char)data;
            System.out.print(dataChar);
            data = reader.read();
        }
        reader.close();
    }
}
