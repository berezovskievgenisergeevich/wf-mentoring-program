package com.epam.workingWithFiles.homework.task1;

import java.io.Serializable;

public class Book implements Serializable {
    public transient int notSerializableField = 100;
    public String name;
    public String author;

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "notSerializableField=" + notSerializableField +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
