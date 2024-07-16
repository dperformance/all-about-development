package com.dev.java.enumm.case4;

public class EnumMapperValue {

    private String code;
    private String title;

    EnumMapperValue(EnumMapperType enumMapperType) {
        this.code = enumMapperType.getCode();
        this.title = enumMapperType.getTitle();
    }

    @Override
    public String toString() {
        return "EnumMapperValue{" +
                "code='" + code + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
