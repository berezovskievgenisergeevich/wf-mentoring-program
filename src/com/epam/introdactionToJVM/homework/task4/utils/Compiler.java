package com.epam.introdactionToJVM.homework.task4.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public final class Compiler {
    private static String javac = "C:\\Program Files\\Java\\jdk-13.0.1\\bin\\javac.exe";

    public static void compile() throws IOException, InterruptedException {



        //Проверяем, существует ли такой файл (javac.exe)
        File jc = new File(javac);
         File file = new File("C:\\Users\\Yauhen_Berazouski\\workfusion-workspace\\wf-mentoring-program\\src\\com\\epam\\introdactionToJVM\\homework\\task4\\model\\Cat.java");
        if (!jc.isFile())
            throw new FileNotFoundException("Компилятор по адресу " + jc.getAbsolutePath() + " недоступен ");
        System.out.println("Компилируем " + jc.getAbsolutePath() + " " + file.getAbsolutePath());


        //Запускаем компилятор javac, чтобы получить байт код внешнего класса
        Process p1 = Runtime.getRuntime().exec(javac + " " + file.getAbsolutePath());

        //Если javac завершился с ошибкой, выбрасываем Exception (здесь он самописный)
        //т.к. мне необходимо было проверять синтаксис класса, который подключался.
        //Таким образом, если возникала ошибка компиляции, то процесс p1 мог вернуть текст
        //ошибки (поток байт) с помощью функции getErrorStream()
        if (p1.waitFor() != 0)
            try {
                throw new Exception("Ошибка компиляции: " + p1.getErrorStream());
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        //Здесь мы уже имеем созданный файл с байт-кодом
        System.out.println("Компиляция завершена");
    }
}
