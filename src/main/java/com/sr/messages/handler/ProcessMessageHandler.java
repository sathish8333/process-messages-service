package com.sr.messages.handler;

import com.sr.messages.service.ProcessMessageService;
import org.apache.kafka.streams.StreamsBuilder;
import org.springframework.beans.factory.annotation.Autowired;

public class ProcessMessageHandler {
    @Autowired
    static
    ProcessMessageService processMessageService;

    public static void processMessage(StreamsBuilder stb){
        processMessageService.consumeAndProcessMessages(stb);
    }
}
