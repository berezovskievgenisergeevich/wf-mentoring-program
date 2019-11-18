package com.epam.javaCore3.homework.task8;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class Tree {
    private int value;
    private List<Tree> children = new LinkedList<>();

    public Tree(int value, List<Tree> children) {
        super();
        this.value = value;
        this.children.addAll(children);
    }

    public Tree(int value, Tree... children) {
        this(value, asList(children));
    }

    public int getValue() {
        return value;
    }

    public List<Tree> getChildren() {
        return Collections.unmodifiableList(children);
    }

    public Stream<Tree> flattened() {

        return this.getChildren().stream().map(Tree::flattened)
                .reduce(Stream.of(this), Stream::concat);
    }

    public List<Integer> getAllValues() {
        return flattened().map(tree -> tree.getValue()).collect(Collectors.toList());
    }

    public List<Integer> getEvenValues() {
        return getAllValues().stream().filter(value -> value % 2 == 0).collect(Collectors.toList());

    }

    // Sum of even values:
    public Optional<Integer> sumOfEvenValues() {
        return Optional.of(getAllValues().stream().mapToInt(integer -> integer.intValue()).sum());
    }

    public boolean isContains13() {
        return getAllValues().stream().anyMatch(integer -> integer == 13);//filter(integer -> integer == 13).count() > 0;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "value=" + value +
                '}';
    }
}
