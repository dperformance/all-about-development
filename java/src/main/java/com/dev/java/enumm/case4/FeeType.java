package com.dev.java.enumm.case4;

/**
 * FeeType = 요금유형
 */
public enum FeeType implements EnumMapperType {
    PERCENT("정율"),
    MONEY("정액");

    private String title;

    FeeType(String title) {
        this.title = title;
    }

    @Override
    public String getCode() {
        return null;
    }

    @Override
    public String getTitle() {
        return null;
    }
}
