package com.dev.java.xml;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@XmlRootElement(name = "RESPONSE_DATA")
//@XmlRootElement
public class Person {
//    @XmlElement
    @XmlElement(name = "FULL_NAME")
    private String name;
    @XmlElement
    private String email;

    @Builder
    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // 생성자, getter, setter 생략
}
