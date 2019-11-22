package com.epam.introdactionToJVM.homework.task4;

import com.epam.introdactionToJVM.homework.task4.utils.Compiler;
import com.epam.introdactionToJVM.homework.task4.utils.Creator;
import com.epam.introdactionToJVM.homework.task4.utils.Invoker;

import java.io.IOException;

public class Runner {
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
         /* //Формируем абсолютный путь к файлу с байт-кодом
        int pointIndex = file.getAbsolutePath().lastIndexOf(".");
        String absulutePatch = file.getAbsolutePath().substring(0, pointIndex);*/

        Compiler.compile();

        Invoker.invokeCatAndDogMethods(Creator.createDogAndCat());

    }
}
