package com.dev.java.enumm.case4;

import jakarta.validation.constraints.Pattern;

import java.util.Arrays;

public enum EnumType {
    KAKAO("kakao"),
    NAVER("naver");

    @Pattern(regexp = "^(kakao|naver|zkzkzk)$")
    private String title;


    EnumType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public static EnumType findByCompany(String company) {
        return Arrays.stream(EnumType.values())
                .filter(s -> s.title.equals(company))
                .findAny()
                .orElse(null);
    }

}
