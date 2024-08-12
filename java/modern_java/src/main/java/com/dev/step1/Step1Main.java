package com.dev.step1;

import com.dev.global.dto.Apple;
import com.dev.global.enums.Color;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Step1Main {

    /*
        TODO
        요구사항
        1. 사과중에 녹색사과만 판별해서 결과를 리턴해준다.

        개발후 추가 요구 사항
        1. 녹색사과가 아닌 빨간사과를 판별한다.
        2. 빨간사과중에서도 무게가 100 이상인 사과만 판별한다.


        Step1Main의 문제점.
        if문 안의 코드만 변경되고 나머지 코드는 계속 중복 된다.
     */


    private static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getColor() == Color.GREEN) {
                result.add(apple);
            }
        }
        return result;
    }

    private static List<Apple> filterRedApplesAndWeight(List<Apple> inventory){
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (Color.RED.equals(apple.getColor()) && apple.getWeight() >= 100) {
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
        List<Apple> result = filterGreenApples(apples);
        List<Apple> result1 = filterRedApplesAndWeight(apples);
        log.info("result    : {}", result);
        log.info("result1   : {}", result1);
    }
}
