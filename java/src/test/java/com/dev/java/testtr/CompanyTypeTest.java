package com.dev.java.testtr;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompanyTypeTest {

    private CompanyType selectCompanyType() {
        return CompanyType.SAMSUNG;
    }

    private String selectCompanyCode() {
        return "sds";
    }

    @Test
    @DisplayName("모회사를 찾아라")
    void 모회사를찾아라() {
        CompanyType type = selectCompanyType();
        String code = selectCompanyCode();

        CompanyType byCompany = CompanyType.findByCompany(code);

        Assertions.assertThat(byCompany.name()).isEqualTo(CompanyType.SAMSUNG.name());

        CompanyType byCompany1 = CompanyType.findByCompany(type.getTitle());

        Assertions.assertThat(byCompany1).isNull();


        int batchSize = 100; // 배치 사이즈 설정

    }

}