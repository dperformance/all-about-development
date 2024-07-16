package com.dev.java.enumm.case3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum PayGroupAdvanced {
    CASH("현금", List.of(PayType.ACCOUNT_TRANSFER, PayType.REMITTANCE, PayType.ON_SITE_PAYMENT, PayType.TOSS)),
    CARD("카드", List.of(PayType.PAYCO, PayType.CARD, PayType.KAKAO_PAY, PayType.BAEMIN_PAY)),
    ETC("기타", List.of(PayType.POINT, PayType.COUPON)),

    EMPTY("없음", Collections.EMPTY_LIST);

    private String title;

    private List<PayType> payList;

    PayGroupAdvanced(String title, List<PayType> payList) {
        this.title = title;
        this.payList = payList;
    }

    public static PayGroupAdvanced findByPayType(PayType payType) {
       return  Arrays.stream(PayGroupAdvanced.values())
                .filter(payGroup -> payGroup.hasPayCode(payType))
                .findAny()
                .orElse(EMPTY);
    }

    public boolean hasPayCode(PayType payType) {
        return payList.stream()
                .anyMatch(pay -> pay == payType);
    }

    public String getTitle() {
        return title;
    }
}
