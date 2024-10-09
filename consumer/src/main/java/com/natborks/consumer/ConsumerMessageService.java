package com.natborks.consumer;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumerMessageService {

    private final ConsumerRepository consumerRepository;

    public ConsumerMessageService(ConsumerRepository consumerRepository) {
        this.consumerRepository = consumerRepository;
    }

    public List<Message> getMessages() {

        return consumerRepository.findAll();
    }
}
