package com.dev.java.enumm.test;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ClientRequestDataTest {

    @Test
    @DisplayName("ClientRequestData를 검증하다")
    void createWithBuilder() {
        String dateFrom = "2023-06-28 00:00:00";
        String dateTo = "2023-06-28 23:59:59";
        ClientRequestData requestData = ClientRequestData.builder()
                .date_from(dateFrom)
                .date_to(dateTo)
                .limit(10)
                .offset(0)
                .build();

        assertThat(requestData.getDate_from()).isEqualTo(dateFrom);
        assertThat(requestData.getDate_to()).isEqualTo(dateTo);
        assertThat(requestData.getLimit()).isEqualTo(10);
        assertThat(requestData.getOffset()).isEqualTo(0);

    }

}