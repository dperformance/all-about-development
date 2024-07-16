package com.dev.java.testtr;

import java.util.Arrays;
import java.util.List;

public enum CompanyType {
    SAMSUNG("samsung", List.of("sds", "display")),
    KAKAO("kakao", List.of("kakaoTalk", "bank", "entertainment", "games", "mobility")),
    NAVER("naver", List.of("financial", "line", "cloud", "webtoon"));

    private String title;

    private List<String> companyList;

    CompanyType(String title, List<String> companyList) {
        this.title = title;
        this. companyList = companyList;
    }

    public static CompanyType findByCompany(String company) {
        return Arrays.stream(CompanyType.values())
                .filter(companyGroup -> companyGroup.hasCompanyCode(company))
                .findAny()
                .orElse(null);
    }

    private boolean hasCompanyCode(String company) {
        return companyList.stream()
                .anyMatch(code -> code.equals(company));
    }

    public String getTitle() {
        return title;
    }
}
