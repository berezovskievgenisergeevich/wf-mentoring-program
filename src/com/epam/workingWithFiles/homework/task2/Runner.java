package com.epam.workingWithFiles.homework.task2;

import com.epam.workingWithFiles.homework.task2.utils.Solver;

/**
 * Task 2.
 * DiskAnalyzer
 * <p>
 * Write a command-line DiskAnalyzer utility that takes a path (for example, C:\) and a function number as input, and correctly handles incorrect paths or function numbers. The utility displays the results of its work in a file. The program should work for the C: drive of your working machine. The following features are supported:
 * <p>
 * 1. (5 points) Search for the file name with the maximum number of letters ‘s ' in the name, output the path to it.
 * <p>
 * 2. (5 points) Top-5 files with the largest size
 * <p>
 * 3. (5 points) Average file size in the specified directory or any of its subdirectories
 * <p>
 * 4. (5 points) the Number of files and folders divided by the first letters of the alphabet (for example, the letter A-starts with 100,000 files and 200 folders)
 */
public class Runner {
    public static void main(String[] args) {
        Solver.startProgram();
    }
}
