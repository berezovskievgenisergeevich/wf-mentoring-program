package com.epam.javaCore3.homework.task5;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private String title;
    private List<Author> authors;
    int numberOfPages;


    public Book(String title, List<Author> authors, int numberOfPages) {
        this.title = title;
        if (authors == null)
            this.authors = new ArrayList<>();
        else
        this.authors = authors;
        this.numberOfPages = numberOfPages;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", authors=" + authors +
                ", numberOfPages=" + numberOfPages +
                '}';
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
    public void addAuthor(Author author){
        this.authors.add(author);
    }

    public String getTitle() {
        return title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }
}
