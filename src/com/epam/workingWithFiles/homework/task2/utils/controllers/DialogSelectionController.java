package com.epam.workingWithFiles.homework.task2.utils.controllers;

import com.epam.workingWithFiles.homework.task2.utils.models.DialogSelectionModel;
import com.epam.workingWithFiles.homework.task2.utils.models.Info;

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
            isNumberInRange(number);
            return number;
        } catch (NumberFormatException e) {
            repeatSelectedFunctionNumber();
        }

        return number;
    }

    private static int repeatSelectedFunctionNumber() {
        return DialogSelectionController.getSelectedFunctionNumber(DialogSelectionModel.enterFunctionDialog());
    }

    private static boolean isNumberInRange(int number) {
        if (isInRange(number))
            return true;
        printNotRangeInfo(number);
        throw new NumberFormatException();
    }

    private static boolean isInRange(int number) {
        return number > Info.MIN_RANGE_NUMBER && number < Info.MAX_RANGE_NUMBER;
    }

    private static void printNotRangeInfo(int number) {
        System.out.printf("You entered an incorrect number [%s]\n" +
                "It's not in the range [%s-%s]\n", number, Info.MIN_RANGE_NUMBER + 1, Info.MAX_RANGE_NUMBER - 1);
    }

}
