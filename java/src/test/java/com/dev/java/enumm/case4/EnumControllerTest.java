package com.dev.java.enumm.case4;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EnumController.class)
class EnumControllerTest {

    private static final String COMPANY = "kakao";
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EnumService enumService;

    @BeforeEach
    void setUp() {
        String result = EnumType.KAKAO.getTitle();

        given(enumService.getCompany(EnumType.KAKAO)).willReturn(result);
    }

    @Test
    @DisplayName("Enum컨트롤러를 확인한다.")
    void 컨트롤러_요청() throws Exception {
        mockMvc.perform(
                get("/enum/test/{id}", COMPANY)
        ).andExpect(status().isOk());

        Assertions.assertThat(enumService.getCompany(EnumType.KAKAO)).isEqualTo("kakao");
        verify(enumService).getCompany(any(EnumType.class));
    }
}








