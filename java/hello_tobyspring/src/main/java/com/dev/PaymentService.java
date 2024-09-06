package com.dev;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public abstract class PaymentService {
    public Payment prepare(Long orderId, String currency, BigDecimal foreignCurrencyAmount) throws IOException {
        BigDecimal exRate = getExRate(currency);                                // 원화환율 가져오기
        BigDecimal convertedAmount = foreignCurrencyAmount.multiply(exRate);    // 원화금액을 계산
        LocalDateTime validUntil = LocalDateTime.now().plusMinutes(30);         // 언제까지 유효한지.

        return new Payment(orderId, currency, foreignCurrencyAmount, exRate, convertedAmount, validUntil);
    }

    abstract BigDecimal getExRate(String currency) throws IOException;
}
