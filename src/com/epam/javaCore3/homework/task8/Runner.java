package com.epam.javaCore3.homework.task8;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {

        List<Tree> children = new ArrayList<>();

        children.add(new Tree(1, new ArrayList<>()));
        children.add(new Tree(2, new ArrayList<>()));

        Tree tree = new Tree(0, (Tree) null);
        System.out.println(tree);
    }
}
