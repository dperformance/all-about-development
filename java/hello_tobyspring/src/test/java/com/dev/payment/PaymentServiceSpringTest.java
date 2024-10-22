package com.dev.payment;

import com.dev.TestPaymentConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.Clock;
import java.time.LocalDateTime;

import static java.math.BigDecimal.TEN;
import static java.math.BigDecimal.valueOf;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestPaymentConfig.class)
public class PaymentServiceSpringTest {

    @Autowired
    PaymentService paymentService;

    @Autowired
    ExRateProviderStub exRateProviderStub;

    @Autowired
    Clock clock;

    @Test
    @DisplayName("prepare 메소드가 요구사항 3가지를 잘 충족했는지 검증")
    void convertedAmount() throws IOException {
        // exRate : 1000
        Payment payment = paymentService.prepare(1L, "USD", TEN);

        // 환율정보 가져온다.
        Assertions.assertThat(payment.getExRate()).isEqualByComparingTo(valueOf(1_000));
        // 원화환산금액 계산 (환율 * 외환금액)
        Assertions.assertThat(payment.getConvertedAmount()).isEqualByComparingTo(valueOf(10_000));


        // exRate : 500
        exRateProviderStub.setExRate(valueOf(500));
        Payment payment2 = paymentService.prepare(1L, "USD", TEN);

        // 환율정보 가져온다.
        Assertions.assertThat(payment2.getExRate()).isEqualByComparingTo(valueOf(500));
        // 원화환산금액 계산 (환율 * 외환금액)
        Assertions.assertThat(payment2.getConvertedAmount()).isEqualByComparingTo(valueOf(5_000));
    }

    @Test
    void validUntil() throws IOException {
        System.out.println(this.clock);
        Payment payment = paymentService.prepare(1L, "USD", BigDecimal.TEN);



        // valid until이 prepare() 30분 뒤로 설정됐는가?
        LocalDateTime now = LocalDateTime.now(this.clock);
        LocalDateTime expectedValidUntil = now.plusMinutes(30);

        System.out.println(now);

        Assertions.assertThat(payment.getValidUntil()).isEqualTo(expectedValidUntil);
    }
}