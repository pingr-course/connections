package com.pingr.conections.Connections;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.List;

@Configuration
public class PrePopulateAccountConfig {
    @Bean
    CommandLineRunner commandLineRunner(AccountRepository repo) {
        return args -> {
            Account one = new Account(1L, "oneaccount", new HashSet<>());
            Account two = new Account(2L, "twoaccount", new HashSet<>());

            repo.saveAll(List.of(one, two));
        };
    }
}
