package com.natborks.producer;

import com.natborks.producer.Message;
import com.natborks.producer.MessageRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public void saveMessage(Message message) {
        messageRepository.save(message);
    }

    public List<Message> getMessages() {
        List<Message> messages = messageRepository.findAll();

        return messages;
    }
}
