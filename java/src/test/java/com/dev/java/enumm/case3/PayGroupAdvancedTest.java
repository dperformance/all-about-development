package com.dev.java.enumm.case3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PayGroupAdvancedTest {

    private PayType selectPayType() {
        return PayType.KAKAO_PAY;
    }

    @Test
    public void PayGroup_에게_물어보기() {
        PayType payType = selectPayType();
        PayGroupAdvanced result = PayGroupAdvanced.findByPayType(payType);

        Assertions.assertThat(result.name()).isEqualTo("CARD");
        Assertions.assertThat(result.getTitle()).isEqualTo("카드");
    }

}