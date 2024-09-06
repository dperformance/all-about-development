package com.dev;

import java.math.BigDecimal;

public class SimpleExRatePaymentService extends PaymentService{
    @Override
    BigDecimal getExRate(String currency) {
        if (currency.equals("USD")) return BigDecimal.valueOf(1000);

        throw new IllegalArgumentException("지원되지 않는 통화입니다.");
    }
}
