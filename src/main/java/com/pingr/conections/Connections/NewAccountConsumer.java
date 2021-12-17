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
    public void consume(Account account) throws IOException {
        System.out.println(account);
    }
}
