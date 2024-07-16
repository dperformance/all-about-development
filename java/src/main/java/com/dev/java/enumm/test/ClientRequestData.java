package com.dev.java.enumm.test;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@Builder
public class ClientRequestData {

    @Pattern(regexp = "^20[1-3]\\d-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])T([01]\\d|2[0-3]):([0-5]\\d):([0-5]\\d)(Z|\\s*)",
            message = "yyyy-mm-ddThh:mm:ssZ 또는 yyyy-mm-ddThh:mm:ss 형식과 일치해야 합니다.")
    @JsonProperty("date_from")
    private String date_from;

    @JsonProperty("date_to")
    @Pattern(regexp = "^20[1-3]\\d-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])T([01]\\d|2[0-3]):([0-5]\\d):([0-5]\\d)(Z|\\s*)",
            message = "yyyy-mm-ddThh:mm:ssZ 또는 yyyy-mm-ddThh:mm:ss 형식과 일치해야 합니다.")
    private String date_to;

    @Min(0)
    private Integer offset;

    @Min(10)
    @Max(1000)
    private Integer limit;

}
