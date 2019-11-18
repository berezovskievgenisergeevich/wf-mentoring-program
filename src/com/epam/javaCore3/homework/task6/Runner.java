package com.epam.javaCore3.homework.task6;

import java.util.stream.Collector;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;

public class Runner {
    public static void main(String[] args) {
        Stream<Box> boxes = Stream.of(
                new Box(1),
                new Box(3.2),
                new Box(0.4),
                new Box(4.1),
                new Box(0.11)
        );



        MinMaxCollector.MinMax<Box> boxMinMax = boxes
                .collect(new MinMaxCollector<>(comparing(Box::getWeight)));

        System.out.println(boxMinMax);

    }
}
