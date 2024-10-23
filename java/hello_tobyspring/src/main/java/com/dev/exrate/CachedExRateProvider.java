package com.dev.exrate;

import com.dev.payment.ExRateProvider;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CachedExRateProvider implements ExRateProvider {

    private final ExRateProvider target;

    private BigDecimal cachedExRate;

    private LocalDateTime cacheExpiryTime;

    public CachedExRateProvider(ExRateProvider target) {
        this.target = target;
    }

    @Override
    public BigDecimal getExRate(String currency) {
        if (cachedExRate == null || cacheExpiryTime.isBefore(LocalDateTime.now())) {
            this.cachedExRate = this.target.getExRate(currency);
            cacheExpiryTime = LocalDateTime.now().plusSeconds(3);
            System.out.println("Cache updated");
        }
        return cachedExRate;
    }
}
