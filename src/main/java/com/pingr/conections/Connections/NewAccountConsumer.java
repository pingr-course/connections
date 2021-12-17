package com.pingr.conections.Connections;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashSet;

@Component
public class NewAccountConsumer {
    @KafkaListener(
            topics = "${topic.accounts}",
            groupId = "connection_new_accounts"
    )
    public void consume(String message) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Account account = mapper.readValue(message, Account.class);
        System.out.println(account);
    }
}
