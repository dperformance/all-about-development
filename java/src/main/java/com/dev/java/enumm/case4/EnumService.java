package com.dev.java.enumm.case4;

import org.springframework.stereotype.Service;

@Service
public class EnumService {

    public String getCompany(EnumType company) {
        return switch (company) {
            case KAKAO, NAVER -> company.getTitle();
        };
    }
}
