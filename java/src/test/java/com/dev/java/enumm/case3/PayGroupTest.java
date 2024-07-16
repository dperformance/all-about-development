package com.dev.java.enumm.case3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PayGroupTest {

    private String selectPayCode() {
        return "BAEMIN_PAY";
    }

    @Test
    public void PayGroup에게_직접_결제종류_물어보기_문자열 () {
        String code = selectPayCode();
        PayGroup payCode = PayGroup.findByPayCode(code);

        Assertions.assertThat(payCode.getTitle()).isEqualTo("카드");
        Assertions.assertThat(payCode.name()).isEqualTo("CARD");
    }

}