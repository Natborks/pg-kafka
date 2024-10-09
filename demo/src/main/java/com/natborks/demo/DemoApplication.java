package com.natborks.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.codec.ServerSentEvent;
import reactor.core.publisher.Flux;

import java.time.LocalTime;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner start(ServerSentEventConsumer service) throws Exception {
		return args -> {
			Flux<ServerSentEvent<String>> eventStream = service.consume();

			eventStream.subscribe(ctx ->
					System.out.println("Current time: {}, content[{}] " + LocalTime.now() + ctx.data()));
		};
	}

}
