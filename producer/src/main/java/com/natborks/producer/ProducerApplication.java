package com.natborks.producer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
public class ProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProducerApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}


	//I need help with this
	// I wanted a way to generify receiving messages from the API, but this is what I settled on
	// Both Sender and receiver should have a standard message format that is used to send and receive messages
	@Bean
	public CommandLineRunner run(ApiService apiService, MessageService messageService) throws Exception {
		return args -> {

			List<Message> list = apiService.getMessages();

			for (Message item :
					list) {
				Message message = new Message();
				message.setData(item.data);
				messageService.saveMessage(message);
			}


		};
	}

}
