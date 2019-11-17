package com.epam.javaCore3.homework.task6;

public class Box {
    double weight;

    public Box(double param) {
        this.weight = param;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Box{" +
                "weight=" + weight +
                '}';
    }
}
