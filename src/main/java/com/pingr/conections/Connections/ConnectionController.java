package com.pingr.conections.Connections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;

@RestController
@RequestMapping(path = "/api/v1/connections")
public class ConnectionController {
    private final AccountService accountService;
    private final ProducerService producer;

    @Autowired
    public ConnectionController(AccountService accountService, ProducerService producer) {
        this.accountService = accountService;
        this.producer = producer;
    }

    @PostMapping(path = "/{ida}/{idb}")
    public void stablishFriendship(@PathVariable("ida") Long ida, @PathVariable("idb") Long idb) {
        this.accountService.stablishFriendshipBetween(ida, idb);
    }

    @GetMapping(path = "/{id}")
    public Account getOne(@PathVariable("id") Long id) {
        Account one = this.accountService.findOne(id);
        System.out.println(one);
        return one;
    }

    @PostMapping(path = "/test")
    public Account fake() {
        Account account = new Account(12L, "fooname", new HashSet<>());
        this.producer.sendMessage(account);
        return account;
    }
}
