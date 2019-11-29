package com.epam.workingWithFiles.lectures.bufferedReader;

import java.io.*;

public class BufferedReaderDemo {
    private static String filePath = "src\\com\\epam\\workingWithFiles\\lectures\\test_file.txt";
    private static String filePathOut = "src\\com\\epam\\workingWithFiles\\lectures\\test_file1.txt";

    public static void main(String[] args) throws IOException {
        BufferedReader inReader = null;
        PrintWriter outWriter = null;

        inReader = new BufferedReader(new FileReader(filePath));
        outWriter = new PrintWriter(new FileWriter(filePathOut));

        String line = inReader.readLine();
        while (line != null) {
            outWriter.println(line + " add info");
            line = inReader.readLine();
        }
        inReader.close();
        outWriter.close();
    }
}
