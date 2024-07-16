package com.dev.java.modernjava.firstfilter;

import com.dev.java.modernjava.common.Apple;
import com.dev.java.modernjava.common.Color;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class Filter3Main {
    public static List<Apple> filterApples(List<Apple> inventory, Color color, int weight) {
        return null;
    }

    public static void main(String[] args) {
        List<Apple> apples = List.of(
                new Apple(Color.RED, 151),
                new Apple(Color.RED, 100),
                new Apple(Color.GREEN, 120),
                new Apple(Color.BLUE, 130),
                new Apple(Color.RED, 150)
        );

        // 모든 속성을 파라미터화 하게 된다면 아래와 같이 정체를 알 수 없는 요청을 해야 함.
        List<Apple> greenApples = filterApples(apples, Color.GREEN, 130);
    }

}
