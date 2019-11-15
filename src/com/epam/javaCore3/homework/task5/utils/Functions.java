package com.epam.javaCore3.homework.task5.utils;

import com.epam.javaCore3.homework.task5.Book;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Functions {
    public static boolean isSomeBooksHaveMoreThan200Pages(Book[] books) {
        return Arrays.stream(books).filter(book -> book.getNumberOfPages() > 200).count() > 0 ? true : false;
    }

    public static Book findBookWithMaxNumberOfPages(Book[] books) {
        int maxPagesCount = Arrays.stream(books).mapToInt(book -> book.getNumberOfPages()).max().orElse(-1);
        return Arrays.stream(books).filter(book -> book.getNumberOfPages() == maxPagesCount).collect(toList()).get(0);
    }

    public static Book findBookWithMinNumberOfPages(Book[] books) {
        int minPagesCount = Arrays.stream(books).mapToInt(book -> book.getNumberOfPages()).min().orElse(-1);
        return Arrays.stream(books).filter(book -> book.getNumberOfPages() == minPagesCount).collect(toList()).get(0);
    }

    public static List<Book> getBooksWithSingleAuthor(Book[] books) {
        return Arrays.stream(books).filter(book -> book.getAuthors().size() == 1).collect(toList());
    }

    public static List<Book> sortByNumberOfPagesAndTitle(Book[] books) {
        return Arrays.stream(books).sorted((book, t1) -> book.getNumberOfPages() - t1.getNumberOfPages())
                .sorted((book, t1) -> book.getTitle().compareTo(t1.getTitle())).collect(toList());
    }

    public static List<String> getListOfAllTitles(Book[] books) {
        return Arrays.stream(books).map((book) -> book.getTitle()).collect(toList());

    }
}
