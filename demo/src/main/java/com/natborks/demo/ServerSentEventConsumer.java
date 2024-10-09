package com.natborks.demo;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
public class ServerSentEventConsumer {

    private final WebClient webClient;

    private ParameterizedTypeReference<ServerSentEvent<String>> type =
            new ParameterizedTypeReference<ServerSentEvent<String>>() {};

    public ServerSentEventConsumer(WebClient webClient) {
        this.webClient = webClient;
    }

    public Flux<ServerSentEvent<String>> consume() {
        return webClient.get()
                .uri("")
                .retrieve()
                .bodyToFlux(type);
    }


}
