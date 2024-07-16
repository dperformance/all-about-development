package com.dev.java.enumm.test;

import java.util.Arrays;

public enum CompanyType {
    KAKAO("kakao"),
    NAVER("naver"),
    COOPANG("coopang"),
    DAUM("daum"),
    ETC("etc");


    private String title;

    CompanyType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public static CompanyType findByCompany(String code) {
        return Arrays.stream(CompanyType.values())
                .filter(company -> company.getTitle().equals(code))
                .findFirst()
                .orElse(null);
    }
}
