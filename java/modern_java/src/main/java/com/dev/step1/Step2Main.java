package com.dev.step1;

import com.dev.global.dto.Apple;
import com.dev.global.dto.ApplePredicate;
import com.dev.global.enums.Color;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Step2Main {

    /**
     * 이제, 변화하는 요구사항에 유연한 코드를 만들 수 있게 되었다.
     * 요구사항이 변화하면 ApplePredicate 를 상속받은 클래스를 새로 구현해서 사용하면 된다.
     * 이는 자바의 다형성(Polymolphism) 을 이용한 좋은 해결 방법이다.
     * 또한, 컬렉션에서 조건을 만족하는 항목들을 찾는 로직과 각 항목에 적용할 동작을 구분 했다는 점이
     * '동작 파라미터화'의 강점이라고 할 수 있다.
     *
     * 즉, 위의 내용을 정리하면 메서드를 매개변수로 전달하기 위해 메서드를 특정 객체로 감싼 뒤에 전달하고 있다.
     *
     * 하지만 아직도 불만스러운 점이 있다.
     * 바로, 로직을 새로 구현할 때 마다 여러 클래스를 구현해서 인스턴스화 해야한다는 점이다.
     */

    public static class AppleHeavyWeightPredicate implements ApplePredicate {
        @Override
        public boolean test(Apple apple) {
            return apple.getWeight() >= 100;
        }
    }

    public static class FilterGreenApples implements ApplePredicate {
        @Override
        public boolean test(Apple apple) {
            return apple.getColor().equals(Color.GREEN);
        }
    }

    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if(p.test(apple)) {
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

        AppleHeavyWeightPredicate appleHeavyWeightPredicate = new AppleHeavyWeightPredicate();
        List<Apple> apples1 = filterApples(apples, appleHeavyWeightPredicate);
        log.info("appleHeavyWeightPredicate     : {}", apples1);

        FilterGreenApples greenapple = new FilterGreenApples();
        List<Apple> apples2 = filterApples(apples, greenapple);
        log.info("FilterGreenApples             : {}", apples2);
    }
}
