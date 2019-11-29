package com.epam.workingWithFiles.lectures.path;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathDemo {
    private static String filePath = "src\\com\\epam\\workingWithFiles\\lectures\\test_file.txt";

    public static void main(String[] args) throws IOException {
        Path path = Paths.get(filePath);
        System.out.println(path.getFileName() + " in " + path.getFileSystem());
        System.out.println(path.getRoot());
        for (Path element : path) {
            System.out.println(element);
        }

        Path pathDir = Paths.get("");

        // Path newDir = Files.createDirectory(pathDir);
        System.out.println(Files.isReadable(path));
        System.out.println(Files.isWritable(path));
        System.out.println(Files.isExecutable(path));

        // Files.deleteIfExists(path);

    }
}
