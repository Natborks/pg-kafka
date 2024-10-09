package com.natborks.consumer;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ConsumerApiService {

    public static final String ENDPOINT = "https://jsonplaceholder.typicode.com/todos";

     RestTemplate restTemplate;

    public ConsumerApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Message> getMessages() {
        ResponseEntity<List<Message>> response = restTemplate.exchange(
                ENDPOINT,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Message>>() {
                });

        List<Message> messages = response.getBody();

        return messages;
    }
}
