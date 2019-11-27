package com.epam.workingWithFiles.lectures.recursion;

import java.io.File;

public class CatalogRetriever {
    public static void main(String[] args) {
        File dir = new File("c:\\");
        retrieveCatalogs(dir);

    }

    private static void retrieveCatalogs(File dir) {
        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    System.out.println(file.getAbsolutePath());
                    if (file.isDirectory()) {
                        retrieveCatalogs(file);
                    }
                }
            }
        }

    }
}
