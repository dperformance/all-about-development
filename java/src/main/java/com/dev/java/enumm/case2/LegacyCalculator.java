package com.dev.java.enumm.case2;

public class LegacyCalculator {
    public static long calculate(String code, long originValue) {
        if ("CALC_A".equals(code)) {
            return originValue;
        } else if ("CALC_B".equals(code)) {
            return originValue * 10;
        } else if ("CALC_C".equals(code)){
            return originValue * 3;
        } else {
            return 0;
        }
    }
}
