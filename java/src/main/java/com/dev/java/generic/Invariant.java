package com.dev.java.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Invariant {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3);
        printList(list);

//        Collection<?> c = new ArrayList<String>();
//        c.add(new Object()); <-- 컴파일 에러

        FruitBox<Fruit> fruit = new FruitBox<>();
        fruit.add(new Banana());
        fruit.add(new Apple());

        System.out.println(fruit.toString());
    }

    public static void printList(List<?> list) {
        list.forEach(System.out::println);
    }

//    public static void printCollection(Collection<? extends B> collection) {
//        for (A a : collection) { }
//        for (B b : collection) { }
//        for (C c : collection) { }
//        for (D d : collection) { }
//        for (Object o : collection) { }
//    }
//
//    public static void addElement(Collection<? extends B> collection) {
//        collection.add(new A());
//        collection.add(new B());
//        collection.add(new C());
//        collection.add(new D());
//        collection.add(new Object());
//    }
//
//    public static void printCollection1(Collection<? super B> collection) {
//        for (A a : collection) { }
//        for (B b : collection) { }
//        for (C c : collection) { }
//        for (D d : collection) { }
//        for (Object o : collection) { }
//    }
//
//    public static void addElement1(Collection<? super B> collection) {
//        collection.add(new A());
//        collection.add(new B());
//        collection.add(new C());
//        collection.add(new D());
//        collection.add(new Object());
//    }
//
//    // 공변성
//    Object[] Covariance = new Integer[10];
//
//    // 반공변성
//    Integer[] Contravariance = (Integer[]) Covariance;
//
//    // 공변성
//    ArrayList<Object> Covariance1 = new ArrayList<Integer>();
//
//    // 반공변성
//    ArrayList<Integer> Contravariance2 = new ArrayList<Object>();

}
