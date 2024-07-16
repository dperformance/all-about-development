package com.dev.java.resttemplate.api;

import com.dev.java.resttemplate.dto.RestServerRequestData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restserver")
@Slf4j
public class RestServerApi {

    @PostMapping
    public String get(@RequestBody RestServerRequestData requestData) {
        log.info("test >>> : {}", requestData);
        return "hihihi";
    }
}
