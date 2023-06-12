package com.dev.java.global;


import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

class Food {}

class Fruit extends Food {
}

class Vegetable extends Food {
}

class Apple extends Fruit{
}

class Banana {
}

class Carrot extends Vegetable {
}


class MyArrayList<E> {
    public static <E> void copyList(List<? extends E> in, List<? super E> out) {
        for (E e : in) {
            out.add(e);
        }
    }
}

class TT {
    public static void method(List<?> list) {
        List<Object> obj = new ArrayList<>();
        list.add(null);

    }
}
public class Dyson {
    public static void main(String[] args) {
        List<Integer> obj = new ArrayList<>();
        TT.method(obj);
    }
}

class TTT<T extends Banana> {

}



