package com.sr.messages;

import com.sr.messages.service.ProcessMessageService;
import org.apache.kafka.streams.StreamsBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProcessMessagesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProcessMessagesApplication.class, args);
		ProcessMessageService pb = new ProcessMessageService();
		pb.consumeAndProcessMessages(new StreamsBuilder());
	}

}
