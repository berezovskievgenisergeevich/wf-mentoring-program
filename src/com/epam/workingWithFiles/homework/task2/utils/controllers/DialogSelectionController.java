package com.epam.workingWithFiles.homework.task2.utils.controllers;

import com.epam.workingWithFiles.homework.task2.utils.models.DialogSelectionModel;

import java.io.File;

public class DialogSelectionController {

    public static File getSelectedFilePath() {
        return DialogSelectionController.getSelectedFilePath(DialogSelectionModel.enterPathDialog());
    }

    public static int getSelectedFunctionNumber() {
        return DialogSelectionController.getSelectedFunctionNumber(DialogSelectionModel.enterFunctionDialog());
    }

    private static File getSelectedFilePath(String filePath) {
        File path = new File(filePath);
        if (path.exists() && path.isDirectory()) {
            return path;
        } else {
            System.out.printf("You entered [%s] it's incorrect path. Pleas try again\n", filePath);
            repeatSelectFilePath();
        }
        return path;
    }

    private static File repeatSelectFilePath() {
        return DialogSelectionController.getSelectedFilePath(DialogSelectionModel.enterPathDialog());
    }

    private static int getSelectedFunctionNumber(String functionNumber) {
        int number = 0;
        try {
            number = Integer.parseInt(functionNumber);
            return number;
        } catch (NumberFormatException e) {
            System.out.printf("You entered [%s] wrong function number\n" +
                    "enter an integer in the range 1-4\n", functionNumber);
            repeatSelectedFunctionNumber();
        }

        return number;
    }

    private static int repeatSelectedFunctionNumber() {
        return DialogSelectionController.getSelectedFunctionNumber(DialogSelectionModel.enterFunctionDialog());

    }

}
