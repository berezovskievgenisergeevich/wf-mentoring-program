package com.epam.introdactionToJVM.lectures.stackFrame.demo;

import java.util.ArrayList;
import java.util.List;

//Изменить размер хипа
//Run->Edit Configuration-> VM options -Xmx10m (10мегабайт)
public class HeapDemo {
    public static void main(String[] args) {
        List<Integer> crashedList = new ArrayList<>();
        for (int i = 0; i < 1_000_000; i++) {
            crashedList.add(i);
            System.out.println(i);
        }

    }
}
