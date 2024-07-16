package com.dev.java.time;

import io.jsonwebtoken.Jwts;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import javax.crypto.SecretKey;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LocalDateTimeTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
//        LocalDateTime now = LocalDateTime.now();
//        System.out.println("현재 로컬 컴퓨터의 시간 : " + now);

        LocalDateTime now1 = LocalDateTime.now(Clock.systemUTC());
        System.out.println("LocalDateTime.now(Clock.systemUTC(): " + now1);

        LocalDateTime now3 = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
        LocalDateTime now2 = LocalDateTime.now(ZoneId.of("UTC"));

        LocalDateTime kstDate = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
        LocalDateTime utcDate = LocalDateTime.now(ZoneId.of("UTC"));

        System.out.println(kstDate);
        System.out.println(utcDate);

        String format = kstDate.atZone(ZoneId.of("Asia/Seoul"))
                .withZoneSameInstant(ZoneId.of("UTC"))
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));


        System.out.println(format);

        LocalDateTime localDateTime = LocalDateTime.now();

        int year = localDateTime.getYear();
        Month month = localDateTime.getMonth();
        int dayOfMonth = localDateTime.getDayOfMonth();
        DayOfWeek dayOfWeek = localDateTime.getDayOfWeek();
        int dayOfYear = localDateTime.getDayOfYear();
        int monthValue = localDateTime.getMonthValue();

        System.out.println(".getYear()          : " + year);
        System.out.println(".getMonth()         : " + month);
        System.out.println(".getDayOfMonth()    : " + dayOfMonth);
        System.out.println(".getDayOfWeek()     : " + dayOfWeek);
        System.out.println(".getDayOfYear()     : " + dayOfYear);
        System.out.println(".getMonthValue()    : " + monthValue);

        int hour = localDateTime.getHour();
        int minute = localDateTime.getMinute();
        int second = localDateTime.getSecond();
        int nano = localDateTime.getNano();

        System.out.println(".getHour()      : " + hour);
        System.out.println(".getMinute()    : " + minute);
        System.out.println(".getSecond()    : " + second);
        System.out.println(".getNano()      : " + nano);


        // now: 2023년 1월 1일 0시 0분 0초
        LocalDateTime now = LocalDateTime.of(2023, 1, 1, 0, 0, 0);
        System.out.println("plusYears(3)    : " + now.plusYears(3));
        System.out.println("plusMonths(3)   : " + now.plusMonths(3));
        System.out.println("plusDays(3)     : " + now.plusDays(3));
        System.out.println("plusHours(3)    : " + now.plusHours(3));
        System.out.println("plusMinutes(3)  : " + now.plusMinutes(3));
        System.out.println("plusSeconds(3)  : " + now.plusSeconds(3));

        System.out.println("minusYears(3)   : " + now.minusYears(3));
        System.out.println("minusMonths(3)  : " + now.minusMonths(3));
        System.out.println("minusDays(3)    : " + now.minusDays(3));
        System.out.println("minusHours(3)   : " + now.minusHours(3));
        System.out.println("minusMinutes(3) : " + now.minusMinutes(3));
        System.out.println("minusSeconds(3) : " + now.minusSeconds(3));

        Instant now4 = Instant.now();
        System.out.println(now4);

        Instant now5 = Instant.now();

        Duration between = Duration.between(now4, now5);
        System.out.println(between.toMillis() / 1000);

        Instant start = Instant.now();

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Instant end = Instant.now();

        Duration duration = Duration.between(start, end);
        double v = duration.toMillis() / 1000.0;
        double seconds = duration.getSeconds() + (double) duration.getNano() / 1_000_000_000;

        System.out.println(seconds);
        System.out.println(v);


        String str = "123456";
        boolean matches = str.matches("[0-9]+");
        System.out.println(matches);

        String str1 = "dyson1234*-;";
        String strResult = str1.replaceAll("[^a-z0-9]", "@");
        System.out.println(strResult);

        String str2 = "dyson1234*-;";
        String[] strs = str2.split("[0-9]+");

        Arrays.stream(strs)
                .forEach(System.out::println);

        String patternString = "^[0-9]]]]]]]*$";
        Pattern pattern = Pattern.compile(patternString);

        String txt1 = "123123";
        String txt2 = "123이것은숫자입니다00";

        String reg = "^[0-9]*$";

        boolean result = Pattern.matches(reg, txt1); // 첫번째 매개값은 정규표현식이고 두번째 매개값은 검증 대상 문자열
        System.out.println(result); // true

        boolean result2 = Pattern.matches(reg, txt2);
        System.out.println(result2); // false
        System.out.println();


        String something = "hello987*-;hi66"; // 비교할 문자열

        Pattern pattern1 = Pattern.compile("[a-z]+[0-9]+"); // 정규표현식 문자열로 패턴 객체 생성
        Matcher matcher = pattern1.matcher(something); // 패턴 객체로 문자열을 필터링한뒤 그 결과값들을 담은 매처 객체 생성

        // 루프 1번 : hello987
        // 루프 2번 : hi66
        while (matcher.find()) {
            System.out.println(matcher.group());
        }

        String source = "011-4632-1290, 02-889-7661";
        String pattern11 = "(0\\d{1,2})-(\\d{3,4})-(\\d{4})";

        Matcher matcher12 = Pattern.compile(pattern11).matcher(source); // 한방에 매처 객체 반환

        System.out.println("그룹의 개수 : " + matcher12.groupCount());    //그룹화된 개수가 몇개인지 출력

        int i = 0;
        while (matcher12.find()) {
            System.out.println(++i + ": " + matcher12.group() + " -> " + matcher12.group(1) + " 와 " + matcher12.group(2) + " 와 " + matcher12.group(3));
        }


        String source1 = "동해물과 백두산이 마르고 닳도록 하느님이 보우하사 우리나라 만세";
        String pattern123 = "백두산";

        Matcher matcher09 = Pattern.compile(pattern123).matcher(source1);

        while (matcher09.find()) {
            // start()와 end()로 일치하는 부분의 위치를 알아낼 수 있다.
            System.out.println("매칭되는 문자열 위치 : " + matcher09.start() + " ~ " + matcher09.end());
        }

        String patternn = "\\w+@\\w+\\.\\w+(\\.\\w+)?";
        String strrr = "dyson1234__@gmail.c_om.com";
        boolean matches1 = Pattern.matches(patternn, strrr);

        System.out.println(matches1);





        // base64 encode

        String username = "dyson1234";
        String password = "qwer1234";

        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(username, password);
        System.out.println(headers.get("Authorization"));


        Charset charset = StandardCharsets.ISO_8859_1;
        String credentialsString = username + ":" + password;
        byte[] encode = Base64.getEncoder().encode(credentialsString.getBytes(charset));

        String suc = new String(encode, charset);
        System.out.println(suc);

        HttpStatus ok = HttpStatus.OK;
        HttpStatus unauthorized = HttpStatus.FORBIDDEN;


        // QlJfRDIwMjMwNTE1MDI6S1NrS0dLaDYhaA==
        // QlJfRDIwMjMwNTE1MDI6S1NrS0dLaDYhaA==


        System.out.println(Duration.ofMillis(3000));



    }

}
