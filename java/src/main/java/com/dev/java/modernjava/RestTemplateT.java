package com.dev.java.modernjava;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
public class RestTemplateT {




        public static void main(String[] args) {
//            String url = "https://external-api.deliverycharging.com/v1/stations";
            String url = "http://localhost:8080/restserver";
            String username = "charger";
            String password = "B4B1X84LBJIL5QX7WKYTXXJP";

            // Create RestTemplate with Basic Authentication
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
            restTemplate.getInterceptors().add((request, body, execution) -> {
                request.getHeaders().setBasicAuth(username, password);
                return execution.execute(request, body);
            });

            // Set request headers
            HttpHeaders headers = new HttpHeaders();
            headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);

            // Send GET request
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class);

            // Handle response
            if (response.getStatusCode().is2xxSuccessful()) {
                String responseBody = response.getBody();
                System.out.println(responseBody);
            } else {
                System.out.println("Request failed with status code: " + response.getStatusCode());
            }
        }
    }


