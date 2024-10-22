package com.dev.payment;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.*;
import java.time.temporal.ChronoUnit;

public class PaymentTest {

    private Clock clock;

    @BeforeEach
    void setUp() {
        clock = Clock.fixed(Instant.now(), ZoneId.systemDefault());
    }

    @Test
    void createPrepared() {
        Payment payment = Payment.createPrepared(
                1L,
                "USD",
                BigDecimal.TEN,
                BigDecimal.valueOf(1_000),
                LocalDateTime.now(clock) );

        Assertions.assertThat(payment.getConvertedAmount())
                .isEqualByComparingTo(BigDecimal.valueOf(10_000));

        Assertions.assertThat(payment.getValidUntil())
                .isEqualTo(LocalDateTime.now(clock).plusMinutes(30));
    }

    @Test
    void isValid() {
        Payment payment = Payment.createPrepared(
                1L,
                "USD",
                BigDecimal.TEN,
                BigDecimal.valueOf(1_000),
                LocalDateTime.now(clock) );

        Assertions.assertThat(payment.isValid(clock)).isTrue();

        Assertions.assertThat(payment.isValid(
                Clock.offset(clock, Duration.of(30, ChronoUnit.MINUTES)))).isFalse();
    }
}