package com.epam.workingWithFiles.homework.task1;

import java.io.*;

/**
 * Task 1. Serialization
 *
 * Add the ability to serialize/deserialize for an arbitrary hierarchy of objects from any homework.
 * However, all numeric fields should not be subjected to this procedure.
 *
 * Provide test code in which you create multiple instances of different classes of this hierarchy and
 * successfully perform the serialization/deserialization operation.
 */
public class Runner {
    private static String filePath = "src\\com\\epam\\workingWithFiles\\homework\\task1.out";

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        bookSerialization();
        bookDeserialization();

    }

    private static void bookSerialization() throws IOException {
        FileOutputStream fos = new FileOutputStream(filePath);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        Book book = new Book("Osvald Shpengler", "Zakat Evroppi");
        oos.writeObject(book);
        oos.flush();
        oos.close();
        System.out.println("Serialization Success");
    }

    private static Book bookDeserialization() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(filePath);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Book book = (Book) ois.readObject();
        System.out.println(book);
        return book;
    }


}
