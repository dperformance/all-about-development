package com.dev;

import java.util.Arrays;
import java.util.List;

public class Sort {
    public static void main(String[] args) {
//        List<Integer> scores = Arrays.asList(5, 7, 1, 9, 2, 8);
//        List<String> scores = Arrays.asList("a", "z", 'f', "k", "i", "j");
        List<String> scores = Arrays.asList("z", "x", "Spring", "java");
        scores.sort((a1, a2) -> a1.length() - a2.length());

        scores.forEach(System.out::println);
//        Collections.sort();
    }
}
