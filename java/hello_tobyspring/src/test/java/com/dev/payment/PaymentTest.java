package com.dev.payment;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.*;
import java.time.temporal.ChronoUnit;

public class PaymentTest {

    private Clock clock;
    private ExRateProvider exRateProvider;
    private LocalDateTime now;

    @BeforeEach
    void setUp() {
        this.clock = Clock.fixed(Instant.now(), ZoneId.systemDefault());
        this.exRateProvider = new ExRateProviderStub(BigDecimal.valueOf(1_000));
        this.now = LocalDateTime.now(clock);
    }

    @Test
    void createPrepared() throws IOException {
        Payment payment = Payment.createPrepared(
                1L,
                "USD",
                BigDecimal.TEN,
                exRateProvider,
                now);

        Assertions.assertThat(payment.getConvertedAmount())
                .isEqualByComparingTo(BigDecimal.valueOf(10_000));

        Assertions.assertThat(payment.getValidUntil())
                .isEqualTo(LocalDateTime.now(clock).plusMinutes(30));
    }

    @Test
    void isValid() throws IOException {
        Payment payment = Payment.createPrepared(
                1L,
                "USD",
                BigDecimal.TEN,
                exRateProvider,
                now);

        Assertions.assertThat(payment.isValid(clock)).isTrue();

        Assertions.assertThat(payment.isValid(
                Clock.offset(clock, Duration.of(30, ChronoUnit.MINUTES)))).isFalse();
    }
}
