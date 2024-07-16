package com.dev.java.testtr;

import com.dev.java.enumm.case3.PayGroupAdvanced;
import com.dev.java.enumm.case3.PayType;
import com.dev.java.enumm.case4.EnumType;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.json.GsonBuilderUtils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestMain {
    public static void main(String[] args) {
        int ceil = (int) Math.ceil((double) 4000 / 5000);
        System.out.println(ceil);

//        String input = "BNBNAB053003";
//        String input = "HMHM00065602";
        String input = "KPKP00535702";
//        String input = "HEHE00112802";
//        String input = "PWPW10077611";
        String output = input.replaceAll("(.{2})(.{2})(.{6})(.{2})", "$2-$3-$4");
        System.out.println(output);

        PoiStatus available = PoiStatus.AVAILABLE;
        String s = String.valueOf(PoiStatus.AVAILABLE);
        System.out.println(PoiStatus.AVAILABLE);
        System.out.println(s);

        String hostName = "cpt-back-poi1";
        System.out.println(hostName.endsWith("poi2"));


        // ---------------------------------------------------------------------------------------------------------------------
        System.out.println("===========================================================================================");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = "";
        LocalDateTime now = LocalDateTime.now();

        String dateFrom = "2033-06-15 11:19:12";

        String url = "/chargers/status?date_from=" + formattedDateTime;

        String localDateTime = LocalDateTime.parse(dateFrom, formatter).minusDays(10).format(formatter);
        System.out.println("zzzzz : " + localDateTime);


        // 비교할 시간
        LocalDateTime targetTime = LocalDateTime.parse(dateFrom, formatter);
        System.out.println(now);

        // 현재 시간과 비교할 시간의 차이 계산
        long minutesDifference = ChronoUnit.MINUTES.between(targetTime, now);
        System.out.println(minutesDifference);


        System.out.println("year : " + targetTime.getYear());

        // 30분 이내인지 확인

        if (minutesDifference < 0 || minutesDifference >= 30) {
            formattedDateTime = LocalDateTime.now().minusMinutes(29).format(formatter);
            System.out.println("넌 무조건 29분전 고정이다 : " + formattedDateTime);
        } else {
            formattedDateTime = dateFrom;
            System.out.println("ㅇㅋ 너가 설정한 시간으로 하자 :" + formattedDateTime);
        }


        int index = 1;
        System.out.println(index++);
        System.out.println(index++);
        System.out.println(index++);
        System.out.println(index++);
        System.out.println(index);

        System.out.println(LocalDateTime.now().minusDays(1).format(formatter));
        Double ze = 10.3;


        double doubleValue = 10.3;
        int doubleValue1 = (int) doubleValue;
        int intValue = (int) doubleValue;
        String stringValue = String.valueOf(intValue);
        System.out.println(stringValue);

        String category = "G005";
        LocationType locationType = LocationType.OTHER;

        LocationType.values().equals(LocationType.OTHER);
        System.out.println(false);

        String locationId = "EZ001143";

        String prefix = locationId.substring(0, 2) + "-" +  locationId.substring(2);

        System.out.println("dd" + prefix);

        String substring = locationId.substring(0, 2) + "-" + locationId.substring((locationId.length() - 2));
        System.out.println(locationId.length());
        System.out.println(substring);


//        if (date.endsWith("Z")) {
//            inputDateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
//        } else {
//            inputDateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
//        }
//        return LocalDateTime.parse(date, inputDateFormat).format(outputDateFormat);
//    }
        String dateTo = "2023-05-30T00:00:00Z";
        String dateTo1 = "2023-06-16 12:33:10";
        String ttt = "";
        String parse = LocalDateTime.parse(dateTo, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'")).plusHours(9).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String parse1 = LocalDateTime.parse(dateTo1,DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).minusHours(9).format( DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'"));
        System.out.println(parse);
        System.out.println(parse1);

        String operationType = "연중무휴";

        String[] strings = convertOperationType(operationType);
        System.out.println(strings[0] + strings[1]);


        String weeklyTime1 = "00:00~24:00";
        String[] times = weeklyTime1.split("~");

        String[] extendedTimes = new String[3];
        System.arraycopy(times, 0, extendedTimes, 0, times.length);
        extendedTimes[2] = "test";

        System.out.println("Start Time: " + extendedTimes[0]);
        System.out.println("End Time: " + extendedTimes[1]);
        System.out.println("Additional Value: " + extendedTimes[2]);

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter dateFormat11 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

        int minute = LocalDateTime.now().toLocalTime().getMinute();
        String dateFrom1 = LocalDateTime.now().minusMinutes(29).format(dateFormat);

        System.out.println(dateFrom1);

        System.out.println("SEME-PUBLIC".replace("-",""));

        String dateee = "2023-06-22T10:27:09";

        DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
//        LocalTime openTime = LocalTime.parse("05:00");  // 마트의 오픈 시간
//        LocalTime closeTime = LocalTime.parse("21:00");  // 마트의 클로즈 시간
//
//        boolean isOperating = false;
//
//        if (openTime.isBefore(closeTime)) {
//            // 운영 시작 시간이 운영 종료 시간보다 이전인 경우 (e.g., open_time: "05:00", close_time: "21:00")
//            isOperating = currentTime.isAfter(openTime) && currentTime.isBefore(closeTime);
//        } else if (openTime.isAfter(closeTime)) {
//            // 운영 시작 시간이 운영 종료 시간보다 이후인 경우 (e.g., open_time: "18:00", close_time: "10:00")
//            isOperating = currentTime.isAfter(openTime) || currentTime.isBefore(closeTime);
//        }
//
//        if (isOperating) {
//            // 마트는 운영 중입니다.
//            // 추가적인 처리를 수행할 수 있습니다.
//        } else {
//            // 마트는 운영 종료 상태입니다.
//            // 추가적인 처리를 수행할 수 있습니다.
//        }



        String dateFrom112 = LocalDateTime.now(ZoneOffset.UTC)
                .atZone(ZoneId.of("Asia/Seoul"))
//                .withZoneSameInstant(ZoneId.of("UTC+9"))
                .minusMinutes(2)
                .format(DATE_FORMAT);

        System.out.println("권사 짱 : "      + dateee);
        System.out.println("권사 짱 1: "      + dateFrom112);

        System.out.println(LocalDateTime.now(ZoneOffset.UTC));


        LocalDateTime localDateTime1 = LocalDateTime.now(ZoneOffset.UTC)
                .atZone(ZoneOffset.UTC)
                .withZoneSameInstant(ZoneId.of("Asia/Seoul"))
                .toLocalDateTime();

        System.out.println(localDateTime1);




        String date_from= "2023-05-30T00:00:00Z";
        String date_to = "2023-04-30T00:00:00Z";


        String operationTimeType = "S08002";
        int dayOff = Integer.parseInt(operationTimeType.substring(2));
        String testt = operationTimeType.substring(4);
        System.out.println(dayOff);
        System.out.println("testt : " + testt);
        System.out.println(LocalDateTime.now().getDayOfWeek());
        DayOfWeek dayOfWeek = LocalDateTime.now().getDayOfWeek();
        System.out.println(dayOfWeek.name());
        int value = LocalDateTime.now().getDayOfWeek().getValue();
        System.out.println(value);


        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println();

        // PoiStatus----------------------------------------------------------------------------------------------------



        LocalTime openTime = parseCloseTime("09:00");   // 오픈 시간
        LocalTime closeTime = parseCloseTime("18:00");  // 운영종료 시간
        LocalTime currentTime = LocalTime.now(ZoneId.of("Asia/Seoul"));
//        LocalTime currentTime = LocalTime.now();
        System.out.println(currentTime);

//        LocalDateTime.now(ZoneOffset.UTC)
//                .atZone(ZoneOffset.UTC)
//                .withZoneSameInstant(ZoneId.of("Asia/Seoul"));


//        LocalTime currentTime = LocalTime.parse("01:00:59.831246");
        System.out.println("currentTime : " + currentTime);

        System.out.println("LocalTime.MIDNIGHT : " + LocalTime.MIDNIGHT);

        boolean isOperating = false;
        System.out.println("openTime.isBefore(closeTime) : " + openTime.isBefore(closeTime));

        if (openTime.isBefore(closeTime)) { // 운영 시작 시간이 운영 종료 시간보다 이전인 경우 (open_time: "05:00", close_time: "21:00")
            System.out.println("여기");
            isOperating = currentTime.isAfter(openTime) && currentTime.isBefore(closeTime); //
            System.out.println(isOperating);
        } else if (openTime.isAfter(closeTime)) { // 운영 시작 시간이 운영 종료 시간보다 이후인 경우 (open_time: "18:00", close_time: "10:00")
            System.out.println("여기");
            isOperating = currentTime.isAfter(openTime) || currentTime.isBefore(closeTime);
        } else if (openTime.equals(LocalTime.MIDNIGHT) && closeTime.equals(LocalTime.MIDNIGHT)){
            isOperating = true;
        }

        if (isOperating) {
            System.out.println("영업중");
        } else {
            System.out.println("영업 종료");
        }


        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println();

        String openDataId = "ME174001";
        String businessId = "ME";

        String replace = openDataId.replace(businessId, "");
        System.out.println(replace);


        String address = "세종특별자치시 어진동 621, 입구 우측";
        String result = "";
        String pattern = "(.*?[구읍면]) (.*)";
        Matcher matcher = Pattern.compile(pattern).matcher(address);
        System.out.println(matcher);

        if (matcher.matches()) {
            System.out.println(matcher.group());
            result = matcher.group(1);
        } else {
            String[] words = address.split(" ");
            result =  words[0].endsWith("시") ? words[0] : words[0] + " " + words[1];
        }


//        LocalTime currentTime = LocalTime.now(ZoneId.of("Asia/Seoul"));

        LocalDateTime localDateTime12 = LocalDateTime.now(ZoneOffset.UTC)
                .atZone(ZoneOffset.UTC)
                .withZoneSameInstant(ZoneId.of("Asia/Seoul"))
                .toLocalDateTime();

        LocalDateTime now1 = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
        String now2 = LocalDateTime.now(ZoneId.of("Asia/Seoul")).toString();


        System.out.println("rase : " + localDateTime12);

        System.out.println(now1);
        System.out.println(now2);

        String clientDateFrom = "2023-06-28T12:00:33";
        String serverDateFrom = "2023-06-28T12:30:33";
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime clientParse = LocalDateTime.parse(clientDateFrom, formatter2);
        LocalDateTime serverParse = LocalDateTime.parse(serverDateFrom, formatter2);

        long between = ChronoUnit.MINUTES.between(clientParse, serverParse);
        System.out.println("betwwen : " + between);

        LocalDateTime localDateTime2 = serverParse.minusMinutes(29);

        String combinedId = "MEME18316201";

        String id = combinedId.replaceAll("(.{2})(.{2})(.{6})(.{2})", "$2-$3-$4");

        System.out.println(id);
        HttpStatus.OK.name();

        try {
            String hostName1 = InetAddress.getLocalHost().getHostName();
            System.out.println(hostName1);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }

        LocalTime tt = LocalTime.parse(LocalDateTime.now(ZoneId.of("Asia/Seoul")).toLocalTime().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        LocalDate tt1 = LocalDateTime.now(ZoneId.of("Asia/Seoul")).toLocalDate();
        LocalDateTime tt2 = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
        System.out.println(tt);
        System.out.println(tt1);
        System.out.println(tt2);
        System.out.println(tt.getHour() / 4 % 2);


        EnumType kakao = EnumType.KAKAO;

//        EnumType kakao = null;

        EnumType enumType = EnumType.valueOf(kakao.name());


        boolean contains = Arrays.asList(EnumType.values())
                .contains(kakao);
        System.out.println(contains);

        boolean result1 = Arrays.stream(EnumType.values())
                .anyMatch(type -> type.getTitle().equals(kakao.getTitle()));

        System.out.println(result1);

        EnumType enumType1 = Arrays.stream(EnumType.values())
                .filter(company -> company.getTitle().equals(kakao.getTitle()))
                .findAny()
                .orElse(null);

        System.out.println(enumType1);


//        public static PayGroupAdvanced findByPayType(PayType payType) {
//            return  Arrays.stream(PayGroupAdvanced.values())
//                    .filter(payGroup -> payGroup.hasPayCode(payType))
//                    .findAny()
//                    .orElse(EMPTY);
//        }
//
//        public boolean hasPayCode(PayType payType) {
//            return payList.stream()
//                    .anyMatch(pay -> pay == payType);
//        }

        System.out.println("tqsd : " + enumType);

        String code = "line";

        CompanyType byCompany = CompanyType.findByCompany(code);

        if (byCompany == null) {
            System.out.println("null 임다");
        } else {
            System.out.println();
            System.out.println(code + "의 모기업은 " + byCompany.name() + " 입니다.");
        }

        int batchSize = 1000;
        int i = 1000;
        int evList = 11644;

        if ((i + 1) % batchSize == 0 || (i + 1) == evList) {
            System.out.println("d");
        }

        System.out.println((999 + 1) % 1000);



    }

    private static LocalTime parseCloseTime(String closeTime) {
        return closeTime.equals("24:00") ? LocalTime.MIDNIGHT : LocalTime.parse(closeTime);
    }

    private static String[] convertOperationType(String operationType) {
        String weeklyTime = "00:00~24:00";
        weeklyTime.split("~");

        String weekendTime = "09:00~18:00";

        if (operationType.equals("연중무휴")) {
            return weeklyTime.split("~");
        } else if (operationType.equals("주말")) {
            return weekendTime.split("~");
        } else {
            return null;
        }



    }

    private String getLocationId(String locationId) {
        if (locationId.length() == 8 || locationId.length() == 9) {
            return locationId.substring(0, locationId.length() - 6)
                    + "-" +
                    locationId.substring(locationId.length() - 6);
        } else {
            return "";
        }
    }
}
