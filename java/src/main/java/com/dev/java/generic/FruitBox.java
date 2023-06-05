package com.dev.java.generic;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class FruitBox<T> {
    List<T> fruits = new ArrayList<>();

    public void add(T fruit) {
        fruits.add(fruit);
    }
}
