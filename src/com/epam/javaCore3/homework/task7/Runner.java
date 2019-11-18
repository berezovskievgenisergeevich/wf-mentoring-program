package com.epam.javaCore3.homework.task7;

import java.math.BigDecimal;
import java.util.stream.IntStream;

/**
 * Task 7.
 * Math collector for the IntStream
 * <p>
 * · Write a custom collector for the IntStream or integer generator like
 * <p>
 * Stream.iterate(0,i->i+10).limit(1_000_000)
 *
 * This collector should calculate the sum, count, average, min, max over the stream items.
 */
public class Runner {
    public static void main(String[] args) {
        MyBigDecimalSummaryCollector collector =

                IntStream.iterate(0, i -> i + 10).limit(1_000_000).mapToObj(number -> BigDecimal.valueOf(number))
                        .collect(MyBigDecimalSummaryCollector.myBigDecimalSummaryStatistics());

        System.out.println(collector);

    }
}
