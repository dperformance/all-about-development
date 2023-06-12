package com.dev.java.modernjava.filter1;

import com.dev.java.modernjava.common.Apple;
import com.dev.java.modernjava.common.Color;

import java.util.ArrayList;
import java.util.List;

public class Filter1Main {
    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if (apple.getColor() == Color.GREEN) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterRedApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if (apple.getColor() == Color.RED) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterRedApplesAndWeight(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if (apple.getColor() == Color.RED && apple.getWeight() > 150) {
                result.add(apple);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Apple> apples = List.of(
                new Apple(Color.RED, 151),
                new Apple(Color.RED, 100),
                new Apple(Color.GREEN, 120),
                new Apple(Color.BLUE, 130),
                new Apple(Color.RED, 150)
        );

        List<Apple> filterGrrenApples = Filter1Main.filterGreenApples(apples);
        System.out.println(filterGrrenApples);

        List<Apple> filterRedApples = Filter1Main.filterRedApples(apples);
        System.out.println(filterRedApples);

        List<Apple> filterRedApplesAndWeight = Filter1Main.filterRedApplesAndWeight(apples);
        System.out.println(filterRedApplesAndWeight);
    }
}
