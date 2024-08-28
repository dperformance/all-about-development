package com.dev.summary;

import com.dev.global.dto.Apple;
import com.dev.global.dto.ApplePredicate;
import com.dev.global.enums.Color;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Step3Main {

    /**
     * 3. 악명 쿨래스 사용하기.
     *
     * 로직을 새로 구현할때마다 새로 클래스를 구현하고 인스턴스화 하기에는 번거로운 면이 있다.
     * 이를 해결하기 위해 익명클래스를 사용할 수 있다.
     * 익명 클래스란 말 그대로 이름이 없는 클래스로, 이를 이용하면 클래스 선언과 인스턴스화를 동시에 할 수 있다.
     *
     * 하지만, 익명 클래스를 사용하더라도 여전히 반복되는 코드가 많으며, 익명 클래스의 특성상 코드 블럭이 많아져
     * 현재 스코프에서 어떤 변수나 메서드가 호출되는지 혼란을 야기할 수 있다.
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

        // 익명 클래스 사용
        List<Apple> result = filterApples(apples, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return apple.getWeight() > 90;
            }
        });

        log.info("result : {}", result);
    }
}
