package com.dev.java.modernjava.firstfilter;

import com.dev.java.modernjava.common.Apple;
import com.dev.java.modernjava.common.Color;

import java.util.ArrayList;
import java.util.List;

public class Filter2Main {

    public static List<Apple> filterApplesByColor(List<Apple> inventory, Color color) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if (color == apple.getColor()) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if (apple.getWeight() > weight) {
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

        List<Apple> blueApples = Filter2Main.filterApplesByColor(apples, Color.BLUE);
        System.out.println("Blue apples : " + blueApples.toString());

        List<Apple> weightApples = Filter2Main.filterApplesByWeight(apples, 130);
        System.out.println("weight > 130 : " + weightApples.toString());
    }
}
