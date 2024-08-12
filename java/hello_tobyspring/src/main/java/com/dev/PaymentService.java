package com.dev;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

public class PaymentService {
    public Payment prepare(Long orderId, String currency, BigDecimal foreignCurrencyAmount) throws IOException {
        // 환율 가져오기 https://open.er-api.com/v6/latest/
        URL url = new URL("https://open.er-api.com/v6/latest/" + currency);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String response = br.lines().collect(Collectors.joining());
        br.close();

        ObjectMapper mapper = new ObjectMapper();
        ExRateData data = mapper.readValue(response, ExRateData.class);
        BigDecimal exRate = data.rates().get("KRW");

        // 금액 계산
        BigDecimal convertedAmount = foreignCurrencyAmount.multiply(exRate);

        // 유효 시간 계산
        LocalDateTime validUntil = LocalDateTime.now().plusMinutes(30);

        return new Payment(orderId, currency, foreignCurrencyAmount, exRate, convertedAmount, validUntil);
    }

    public static void main(String[] args) throws IOException {
        PaymentService paymentService = new PaymentService();
        Payment payment = paymentService.prepare(100L, "USD", BigDecimal.valueOf(50.7));
        System.out.println(payment);



            // 현재 년도와 월을 가져옵니다.
            LocalDate now = LocalDate.now();
            String yearMonth = now.format(DateTimeFormatter.ofPattern("yyMM"));

            // 생성할 WORK_NO 초기화
            String workNo = "W" + yearMonth;

            // DB에서 해당 월의 최대 번호를 가져옵니다.
            int maxNumber = getMaxNumberFromDB(yearMonth);

            // 새로운 번호 생성
            String newWorkNo = workNo + "_" + String.format("%04d", maxNumber + 1);

            System.out.println("새로운 WORK_NO: " + newWorkNo);


    }

    private static int getMaxNumberFromDB(String yearMonth) {
        // 여기서는 임의로 최대 번호를 1로 설정
        // 실제 구현에서는 DB 조회로 최대 번호를 가져와야 합니다.
        return 10;
    }
}
