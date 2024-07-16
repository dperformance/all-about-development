package com.dev.java.modernjava.predicate.predicate1;

import com.dev.java.modernjava.common.Apple;
import com.dev.java.modernjava.common.ApplePredicate;
import com.dev.java.modernjava.common.Color;

import java.util.ArrayList;
import java.util.List;

public class Predicate2Main {
    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    static class AppleRedAndHeavyPredicate implements ApplePredicate {
        @Override
        public boolean test(Apple apple) {
            return apple.getColor().equals(Color.RED) && apple.getWeight() > 150;
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

        List<Apple> redAndHeavyApples = Predicate2Main.filterApples(apples, new AppleRedAndHeavyPredicate());
        redAndHeavyApples.forEach(System.out::println);
    }
}
