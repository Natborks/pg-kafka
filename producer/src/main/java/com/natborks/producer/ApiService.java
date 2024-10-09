package com.natborks.producer;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Component
public class ApiService {

    private final String ENDPOINT = "https://jsonplaceholder.typicode.com/todos";

    public final RestTemplate restTemplate;

    public ApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Message> getMessages() {
        ResponseEntity<List<Message>> response = restTemplate.exchange(
                ENDPOINT,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Message>>() {
                });

        List<Message> messages =  (List<Message>) response.getBody();

        List<Message> defaultMessages = messages.stream()
                    .map(message -> new Message(message.getId(), "Can't figure out decoupling"))
                    .collect(Collectors.toList());

        return defaultMessages;
    }
}
