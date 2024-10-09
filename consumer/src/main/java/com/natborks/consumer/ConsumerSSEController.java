package com.natborks.consumer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.time.LocalTime;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
public class ConsumerSSEController {
    private final ConsumerMessageService consumerMessageService;

    public ConsumerSSEController(ConsumerMessageService consumerMessageService) {
        this.consumerMessageService = consumerMessageService;
    }

    @GetMapping("/events")
    public SseEmitter eventStream() {
        SseEmitter emitter = new SseEmitter();
        ExecutorService sseMvcExecutor = Executors.newSingleThreadExecutor();
        List<Message> messages = consumerMessageService.getMessages();

        System.out.println("CONSUMER MESSAGES: "+ messages.get(0));
        sseMvcExecutor.execute(() -> {
            executeSseLogic(emitter, messages);
        });
        return emitter;
    }
    private void executeSseLogic(SseEmitter emitter, List<Message> messages) {
        try {
            for (int counter = 0; counter < 200; counter++) {

                // Create an event with a custom event ID and data

                SseEmitter.SseEventBuilder event = SseEmitter.event().id(messages.get(0).getData())
                        .data("Event data at " + LocalTime.now());
                // Send the event to the client
                emitter.send(event);
                // Wait for one second before sending the next event
                Thread.sleep(1000);
            }
            // Mark the end of the event stream
            emitter.complete();
        } catch (IOException | InterruptedException e) {
            emitter.completeWithError(e);
        }
    }
}
