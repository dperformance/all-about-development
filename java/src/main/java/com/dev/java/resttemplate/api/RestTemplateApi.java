package com.dev.java.resttemplate.api;

import com.dev.java.resttemplate.application.RestTemplateService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resttemplate")
public class RestTemplateApi {

    private final RestTemplateService restTemplateService;

    public RestTemplateApi(RestTemplateService restTemplateService) {
        this.restTemplateService = restTemplateService;
    }

    @GetMapping()
    public String get() throws JsonProcessingException {
        restTemplateService.post();
        return "";
    }
}
