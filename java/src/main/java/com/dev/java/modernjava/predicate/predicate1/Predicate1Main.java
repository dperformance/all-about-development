package com.dev.java.modernjava.predicate.predicate1;

import com.dev.java.modernjava.common.Apple;
import com.dev.java.modernjava.common.ApplePredicate;
import com.dev.java.modernjava.common.Color;

import java.util.List;

class AppleHeavyWeightPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > 150;
    }
}

class AppleGreenColorPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return apple.getColor() == Color.GREEN;
    }
}

public class Predicate1Main {
    public static void main(String[] args) {
        List<Apple> apples = List.of(
                new Apple(Color.RED, 151),
                new Apple(Color.RED, 100),
                new Apple(Color.GREEN, 120),
                new Apple(Color.BLUE, 130),
                new Apple(Color.RED, 150)
        );

        ApplePredicate applePredicate = new AppleHeavyWeightPredicate();
        for (Apple apple : apples) {
            System.out.println(applePredicate.test(apple));
        }
    }

}
