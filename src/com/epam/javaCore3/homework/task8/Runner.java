package com.epam.javaCore3.homework.task8;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<Tree> childred2 = new ArrayList<>();
        childred2.add(new Tree(11, new ArrayList<>()));
        childred2.add(new Tree(12, new ArrayList<>()));

        List<Tree> childred3 = new ArrayList<>();
        childred3.add(new Tree(21, new ArrayList<>()));
        childred3.add(new Tree(22, new ArrayList<>()));

        List<Tree> children = new ArrayList<>();

        children.add(new Tree(1, childred2));


        children.add(new Tree(2, childred3));

        Tree tree = new Tree(0, children);
        tree.flattened().forEach(System.out::println);

        System.out.println(tree.getAllValues());
        System.out.println(tree.getEvenValues());
        System.out.println(tree.sumOfEvenValues());
        System.out.println(tree.isContains13());


    }

}
