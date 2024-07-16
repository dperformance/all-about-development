package com.dev.java.resttemplate.application;

import com.dev.java.resttemplate.dto.RestClientRequestData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
@Slf4j
public class RestTemplateService {

    private final RestTemplate restTeamplate;

    private final ObjectMapper objectMapper;

    public RestTemplateService(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTeamplate = restTemplate;
        this.objectMapper = objectMapper;
    }


    public void post() throws JsonProcessingException {
        String url = "http://localhost:8080/restserver";

        // create headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        RestClientRequestData requestData = RestClientRequestData.builder()
                .id("test")
                .name("dyson")
                .build();

        String requestBody = objectMapper.writeValueAsString(requestData);

        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

       ResponseEntity<String> response =  restTeamplate.postForEntity(url, entity, String.class);
       log.info(" >>>> response : {} ", response.getBody());

    }

}
