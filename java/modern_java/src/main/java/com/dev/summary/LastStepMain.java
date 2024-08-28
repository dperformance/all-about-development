package com.dev.summary;

import com.dev.global.dto.Apple;
import com.dev.global.enums.Color;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class LastStepMain {

    public interface Predicate<T> {
        boolean test(T t);
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T t : list) {
            if (predicate.test(t)) {
                result.add(t);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Apple> apples = List.of(
                new Apple(Color.RED, 100),
                new Apple(Color.GREEN, 120),
                new Apple(Color.RED, 90),
                new Apple(Color.GREEN, 70)
        );

        List<Apple> result =
                filter(apples, (Apple apple) -> apple.getWeight() > 100);

        log.info("result : {}", result);
    }
}
