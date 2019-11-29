package com.epam.workingWithFiles.homework.task2.utils;

import com.epam.workingWithFiles.homework.task2.utils.view.DialogSelectionViewer;

import java.io.File;
import java.util.Scanner;

public class Solver {
    public static void solve(File dir, int functionNumber) {
        FilesUtils filesUtils = new FilesUtils(dir);
        switch (functionNumber) {
            case 1:
                System.out.println(filesUtils.getFileWithMaxLettersSInName());
                break;
            case 2:
                System.out.println(filesUtils.getLargestFile());
                break;
            case 3:
                System.out.println(filesUtils.averageFileSize());
                break;
            case 4:
                filesUtils.printStatistics();
                break;
        }
    }

    public static void startProgram() {
        boolean flag = true;
        while (flag) {
            Solver.solve(DialogSelectionViewer.getSelectedFilePath(), DialogSelectionViewer.getSelectedFunctionNumber());
            System.out.println("Press  0 to exit");
            if (new Scanner(System.in).nextLine().equals("0"))
                flag = false;
        }
    }


}
