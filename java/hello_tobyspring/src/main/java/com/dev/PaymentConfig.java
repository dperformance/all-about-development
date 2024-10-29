package com.dev;

import com.dev.exrate.CachedExRateProvider;
import com.dev.exrate.RestTemplateExRateProvider;
import com.dev.payment.ExRateProvider;
import com.dev.payment.PaymentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Clock;

@Configuration
public class PaymentConfig {

    /*
     * ObjectFactory는 구성정보를 가진 클래스로써
     * Runtime에 ExRateProvider 를 생성자를 통해 주입 받아야할 클래스에
     * 어떤 구현체를 넣어줄 것인지 정해주는것이다.
     * 여기서는 WebApiExRateProvider 넣어 주었다.
     *
     * 하여 PaymentService.prepare메서드의 exRateProvider.getExrate()의 동작은
     * WebApiExRateProvider.getExRate()가 실행되는 것이다.
     *
     *
     */

    // 데코레이터 패턴을 위해 cachedExRateProvider()를 주입.
    @Bean
    public PaymentService paymentService() {
        return new PaymentService(cachedExRateProvider(), clock());
    }

    // Runtime에 CachedExRateprovider에 ExRateProvider 구현체를 주입시켜준다.
    @Bean
    public ExRateProvider cachedExRateProvider() {
        return new CachedExRateProvider(exRateProvider());
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public ExRateProvider exRateProvider() {
        return new RestTemplateExRateProvider(restTemplate());
    }

    @Bean
    public Clock clock() {
        return Clock.systemDefaultZone();
    }

}


