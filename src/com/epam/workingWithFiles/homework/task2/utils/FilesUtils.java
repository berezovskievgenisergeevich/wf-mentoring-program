package com.epam.workingWithFiles.homework.task2.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FilesUtils {
    private List<File> fileList;

    public FilesUtils(File dir) {
        fileList = new ArrayList<>();
        retrieveCatalogs(dir);
    }

    /**
     * Search for the file name with the maximum number of letters 's’ in the name, output the path to it
     *
     * @return Absolute file name
     */
    public String getFileWithMaxLettersSInName() {
        Comparator<File> maxLetter = ((file1, file2) -> {
            return getLetterSCount(file1.getName()) - getLetterSCount(file2.getName());
        });
        return fileList.stream().max(maxLetter).get().getAbsolutePath();

    }

    /**
     * Top-5 files with the largest size
     *
     * @return
     */
    public List<File> getLargestFile() {
        List<File> result = new ArrayList<>();
        List<File> tempFiles = fileList;
        for (int i = 0; i < 5; i++) {
            File tempFile = tempFiles.stream().max((file, t1) -> (int) (file.length() - t1.length())).get();
            result.add(tempFile);
            tempFiles.remove(tempFile);
        }
        return result;
    }

    /**
     * The average size of the file in the specified directory, or any subdirectory of it
     *
     * @return
     */
    public double averageFileSize() {
        return fileList.stream().mapToLong(file -> file.length()).average().getAsDouble();
    }

    /**
     * The number of files and folders divided by the first letters of the alphabet
     * (for example, the letter A-starts with 100,000 files and 200 folders)
     */
    public void printStatistics() {
        for (char i = 'a'; i < 'z'; i++) {
            char tempChar = i;
            long filesCount = fileList.stream().filter(file -> file.isFile()).map(file -> file.getName().toLowerCase()).filter(s -> s.startsWith(tempChar + "")).count();
            long dirCount = fileList.stream().filter(dir -> dir.isDirectory()).map(dir -> dir.getName().toLowerCase()).filter(s -> s.startsWith(tempChar + "")).count();
            System.out.printf("the letter [%s]-starts with [%s] files and [%s] folders\n", tempChar, filesCount, dirCount);
        }


    }

    private int getLetterSCount(String string) {
        Pattern pattern = Pattern.compile("([sS])");
        Matcher matcher = pattern.matcher(string);
        int count = 0;
        while (matcher.find())
            count++;
        return count;
    }


    private void retrieveCatalogs(File dir) {
        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    fileList.add(file);

                    if (file.isDirectory()) {
                        retrieveCatalogs(file);
                    }
                }
            }
        }

    }


}
