package com.epam.workingWithFiles.homework.task2.utils.view;

import com.epam.workingWithFiles.homework.task2.utils.controllers.DialogSelectionController;

import java.io.File;

public class DialogSelectionViewer {
    public static File getSelectedFilePath() {
        return DialogSelectionController.getSelectedFilePath();
    }

    public static int getSelectedFunctionNumber() {
        return DialogSelectionController.getSelectedFunctionNumber();
    }

}
