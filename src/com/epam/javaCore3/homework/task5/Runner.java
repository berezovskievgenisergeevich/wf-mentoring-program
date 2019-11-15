package com.epam.javaCore3.homework.task5;

import com.epam.javaCore3.homework.task5.utils.Creator;
import com.epam.javaCore3.homework.task5.utils.Functions;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {

        Creator.generate();

        Author[] authors1 = createAuthors();

        Book[] books = createBooks();

        printIsSomeBooksHaveMoreThen200Pages(books);

        printBookWithMaxNumberOfPages(books);

        printBookWithMinNumberOfPages(books);

        printBooksWithSingleAuthor(books);

        printSortedBooksByNumberOfPagesAndTitle(books);

        printListOfAllTitles(books);

        Arrays.stream(books).forEach(System.out::println);

    }


    public static Book[] createBooks() {
        Book[] books = new Book[Creator.books.size()];
        Creator.books.toArray(books);
        return books;
    }

    public static Author[] createAuthors() {
        Author[] authors = new Author[Creator.authors.size()];
        Creator.authors.toArray(authors);
        return authors;
    }

    public static void printListOfAllTitles(Book[] books) {
        System.out.println("get list of all titles");
        System.out.println(Functions.getListOfAllTitles(books));
    }

    public static void printSortedBooksByNumberOfPagesAndTitle(Book[] books) {
        System.out.println("sort the books by number of pages/title");
        System.out.println(Functions.sortByNumberOfPagesAndTitle(books));
    }

    public static void printBooksWithSingleAuthor(Book[] books) {
        System.out.println("filter books with only single author");
        System.out.println(Functions.getBooksWithSingleAuthor(books));
    }

    public static void printBookWithMinNumberOfPages(Book[] books) {
        System.out.println("find the books with min number of pages;");
        System.out.println(Functions.findBookWithMinNumberOfPages(books));
    }

    public static void printBookWithMaxNumberOfPages(Book[] books) {
        System.out.println("find the books with max  number of pages;");
        System.out.println(Functions.findBookWithMaxNumberOfPages(books));
    }

    public static void printIsSomeBooksHaveMoreThen200Pages(Book[] books) {
        System.out.println("check if some/all book(s) have more than 200 pages:");
        System.out.println(Functions.isSomeBooksHaveMoreThan200Pages(books));
    }
}
