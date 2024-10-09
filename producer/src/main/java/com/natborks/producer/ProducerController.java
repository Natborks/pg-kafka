package com.natborks.producer;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProducerController {

    MessageService messageService;

    public ProducerController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/messages")
    public ResponseEntity<List<Message>> getAllMessages() {
        List<Message> messages = messageService.getMessages();

        System.out.println("MESSAGES" + messages);

        return new ResponseEntity<List<Message>>(messages, HttpStatus.OK);
    }

}
