package com.dev.java.modernjava.common;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class Apple {
    private Color color;

    private int weight;

    @Builder
    public Apple(Color color, int weight) {
        this.color = color;
        this.weight = weight;
    }
}
