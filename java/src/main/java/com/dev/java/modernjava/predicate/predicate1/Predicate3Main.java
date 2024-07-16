package com.dev.java.modernjava.predicate.predicate1;

import com.dev.java.modernjava.common.Apple;
import com.dev.java.modernjava.common.AppleFormatter;
import com.dev.java.modernjava.common.Color;

import java.util.ArrayList;
import java.util.List;

public class Predicate3Main {

    static class AppleFancyFormatter implements AppleFormatter {
        @Override
        public String accept(Apple apple) {
            return  apple.getWeight() > 150 ? "Heavy " + apple.getWeight() + "g" : "Light " + apple.getWeight() + "g";
        }
    }
    public static void appleFormatter(List<Apple> inventory, AppleFormatter p) {
        for (Apple apple : inventory) {
            System.out.println(p.accept(apple));
        }

    }
    public static void main(String[] args) {
        List<Apple> apples = List.of(
                new Apple(Color.RED, 151),
                new Apple(Color.RED, 100),
                new Apple(Color.GREEN, 120),
                new Apple(Color.BLUE, 130),
                new Apple(Color.RED, 150)
        );
        Predicate3Main.appleFormatter(apples, new AppleFancyFormatter());
    }

}
