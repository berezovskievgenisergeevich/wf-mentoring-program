package com.epam.introdactionToJVM.homework.task4.loader;

import java.io.*;

public class MyClassLoader extends ClassLoader {

    //Переопределяем метод findClass, которому надо передать путь к файлу с расширением .class
    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
        //Проверяем, существует ли такой файл
        File file = new File(name + ".class");
        if (!file.isFile())
            throw new ClassNotFoundException("The class [" + name + "] does not exist");

        InputStream inputStream = null;
        try {
            //С помощью потока считываем файл в массив байт
            inputStream = new BufferedInputStream(new FileInputStream(file));
            byte[] b = new byte[(int) file.length()];
            inputStream.read(b);
            //С помощью функции defineClass загружаем класс
            Class c = defineClass(null, b, 0, b.length);
            return c;
        } catch (IOException e) {
            e.printStackTrace();
            throw new ClassNotFoundException("Problems with bytecode");
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}
