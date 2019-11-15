package com.epam.javaCore3.homework.task5;

import java.util.ArrayList;
import java.util.List;

public class Author {
    private String name;
    private short age;
    List<Book> books;

    public Author(String name, short age, List<Book> books) {
        this.name = name;
        this.age = age;
        if (books == null)
            this.books = new ArrayList<>();
        else
            this.books = books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public String getName() {
        return name;
    }

    public short getAge() {
        return age;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    private String getBooksInfo() {
        StringBuffer stringBuffer = new StringBuffer();
        for (Book book : books) {
            stringBuffer.append(book.getTitle()).append(" | ");
        }
        return stringBuffer.toString();
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", books=" + getBooksInfo() +
                '}';
    }
}
