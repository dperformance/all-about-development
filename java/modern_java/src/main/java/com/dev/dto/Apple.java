package com.dev.dto;

import com.dev.global.enums.Color;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class Apple {
    private Color color;

    private int weight;

    @Builder
    public Apple(Color color, int weight) {
        this.color = color;
        this.weight = weight;
    }
}
