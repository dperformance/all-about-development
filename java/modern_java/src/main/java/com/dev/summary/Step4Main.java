package com.dev.summary;

import com.dev.global.dto.Apple;
import com.dev.global.dto.ApplePredicate;
import com.dev.global.enums.Color;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Step4Main {

    /**
     * 4. 람다 표현식 사용하기.
     *
     * Step3Main 같이 익명 클래스까지 사용했지만 여전히 코드가 장황해지고 반복되는 부분은 많다는 문제점을 해결하지 못했다.
     * 그래서 자바 8 부터 람다가 도입되어 드디어 메서드를 직접 함수의 매개변수로 전달이 가능해 졌다.
     */

    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
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
                filterApples(apples, (Apple apple) -> apple.getWeight() > 100);

        log.info(">>>>> : {}", result);
    }
}
