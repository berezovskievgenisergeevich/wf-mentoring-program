package com.epam.javaCore3.homework.task5.utils;

import com.epam.javaCore3.homework.task5.Author;
import com.epam.javaCore3.homework.task5.Book;

import java.util.ArrayList;
import java.util.List;

public class Creator {

    public static int MAX_PAGES_COUNT = 500;
    public static int MIN_PAGES_COUNT = 10;

    public static int MAX_AGE = 100;
    public static int MIN_AGE = 10;


    public static List<Author> authors = new ArrayList<>();
    public static List<Book> books = new ArrayList<>();

    public static void generate() {
        createOneAuthorAndOneBook(1);
        createOneAuthorAndOneBook(2);
        createOneAuthorAndOneBook(3);
        createThoAuthorsAndOneBook(4);
        createThoAuthorsAndOneBook(6);
        createOneAuthorAndThoBooks(7);
        createOneAuthorAndThoBooks(9);
    }

    public static void createOneAuthorAndOneBook(int i) {
        Author author = Creator.createAuthor(i);
        List<Author> authors1 = new ArrayList<>();
        authors1.add(author);
        Book book = Creator.createBook(i, authors1);
        author.addBook(book);

        authors.add(author);
        books.add(book);

    }

    public static void createOneAuthorAndThoBooks(int i) {
        Author author = Creator.createAuthor(i);
        List<Author> authors1 = new ArrayList<>();
        authors1.add(author);
        Book book1 = new Book(generateTitle(i), authors1, generatePages());
        Book book2 = new Book(generateTitle(i + 1), authors1, generatePages());
        author.addBook(book1);
        author.addBook(book2);
        authors.add(author);
        books.add(book1);
        books.add(book2);

    }

    public static void createThoAuthorsAndOneBook(int i) {

        Author author1 = Creator.createAuthor(i);
        Author author2 = Creator.createAuthor(i + 1);
        List<Author> authors1 = new ArrayList<>();
        authors1.add(author1);
        authors1.add(author2);
        Book book = Creator.createBook(i, authors1);
        author1.addBook(book);
        author2.addBook(book);

        authors.add(author1);

        authors.add(author2);
        books.add(book);


    }


    private static Author[] createAuthorsWithoutBook(int count) {
        Author[] authors = new Author[count];
        for (int i = 0; i < count; i++) {
            authors[i] = createAuthor(i);
        }
        return authors;
    }

    private static Book[] createBooksWithoutAuthors(int count) {
        Book[] books = new Book[count];
        for (int i = 0; i < count; i++) {
            books[i] = createBook(i);
        }
        return null;
    }

    public static Book createBook(int titleNumber) {
        return new Book(generateTitle(titleNumber), null, generatePages());
    }

    public static Book createBook(int titleNumber, List<Author> authors) {
        return new Book(generateTitle(titleNumber), authors, generatePages());
    }

    public static Author createAuthor(int nameNumber) {
        return new Author(generateName(nameNumber), generateAge(), null);
    }

    private static String generateName(int i) {
        return "Author name " + i;
    }

    private static short generateAge() {
        return (short) rnd(MIN_AGE, MAX_AGE);
    }

    private static String generateTitle(int i) {
        return "Book Title" + i;
    }

    private static int generatePages() {
        return rnd(MIN_PAGES_COUNT, MAX_PAGES_COUNT);
    }


    /**
     * Method for obtaining a pseudorandom integer from min to max (including max);
     */
    public static int rnd(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }


}
