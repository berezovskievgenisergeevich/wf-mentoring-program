package com.epam.workingWithFiles.homework.task2.utils.models;

import java.util.Scanner;

public final class DialogSelectionModel {

    public static String enterPathDialog() {
        Scanner scanner = new Scanner(System.in);
        printPathDialogInfo();
        return scanner.nextLine();
    }

    public static String enterFunctionDialog() {
        Scanner scanner = new Scanner(System.in);
        printFunctionDialogInfo();
        return scanner.nextLine();
    }

    private static void printFunctionDialogInfo() {
        System.out.println(Info.FUNCTION_DIALOG_INFO);
    }

    private static void printPathDialogInfo() {
        System.out.println(Info.PATH_DIALOG_INFO);
    }

}
