package com.dev.java.enumm.case2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LegacyCalculatorTest {

    private String selectCode() {
        return "CALC_B";
    }

    private CalculatorType selectType() {
        return CalculatorType.CALC_B;
    }
    @Test
    public void 코드에_따라_서로다른_계산하기_기존방식 () {
        String code = selectCode();
        long originValue = 10000L;
        long result = LegacyCalculator.calculate(code, originValue);

        assertThat(result).isEqualTo(100000L);
    }

    @Test
    public void 코드에_따라_서로다른_계산하기_Enum () {
        CalculatorType code = selectType();
        long originValue = 10000L;
        long calculate = code.calculate(originValue);

        assertThat(calculate).isEqualTo(100000L);


    }

}