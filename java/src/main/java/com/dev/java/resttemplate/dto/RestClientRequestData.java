package com.dev.java.resttemplate.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class RestClientRequestData {

    private String id;

    private String name;

    @Builder
    public RestClientRequestData(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
