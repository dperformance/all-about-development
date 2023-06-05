package com.dev.java.test;


import java.util.ArrayList;
import java.util.List;

class Fruit {}
class Apple extends Fruit {}

class Banana extends Fruit {}

class FruitBox<T> {
    List<T> fruits = new ArrayList<>();

    public void add (T fruit) {
        fruits.add(fruit);
    }
}


interface IAdd<T> {
    public T add(T x, T y);
}

class GenericT <T> {

    public T addBox(T x, T y) {

    }
}

public class Test {
    public static void main(String[] args) {
        IAdd<Integer> o = (x, y) -> x + y;

        int result = o.add(10, 20);

        System.out.println(result);

    }
}
