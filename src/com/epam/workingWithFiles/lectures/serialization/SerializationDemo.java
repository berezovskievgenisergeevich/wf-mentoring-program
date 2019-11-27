package com.epam.workingWithFiles.lectures.serialization;

import java.io.*;

public class SerializationDemo {
    private static String filePath = "src\\com\\epam\\workingWithFiles\\lectures\\test_file.txt";
    private static String serPathOut = "src\\com\\epam\\workingWithFiles\\lectures\\test_file1.txt";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
     /*
      //сериализация (Статические поля не сериализуются)
        FileOutputStream fos = new FileOutputStream("temp.out"*//*serPathOut*//*);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        TestSerial ts = new TestSerial();

        oos.writeObject(ts);
        oos.flush();
        oos.close();*/

        //десериализация
        FileInputStream fis = new FileInputStream("temp.out");
        ObjectInputStream ois = new ObjectInputStream(fis);
        TestSerial ts = (TestSerial) ois.readObject();
        System.out.println(ts.version);
    }
}

class TestSerial implements Serializable {
    public byte version = 100;
    // transient- Запрещает сериализацию
    // public  transient byte version = 100;
    public byte count = 0;

}
