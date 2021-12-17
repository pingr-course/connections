package com.pingr.conections.Connections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;

@RestController
@RequestMapping(path = "/connections")
public class ConnectionsController {
    private final FakeProducer fakeProducer;
    private final AccountService accountService;

    @Autowired
    public ConnectionsController(FakeProducer fakeProducer, AccountService accountService) {
        this.fakeProducer = fakeProducer;
        this.accountService = accountService;
    }

    @PostMapping(path = "/test")
    public Account fakeCreate() {
        Account fake = new Account(12L, "fake username", new HashSet<>());
        this.fakeProducer.sendMessage(fake);
        return fake;
    }

    @PostMapping(path = "/{aid}/{bid}")
    public boolean addFriends(@PathVariable("aid") Long aid, @PathVariable("bid") Long bid) {
        return this.accountService.stablishFriendshipBetween(aid, bid);
    }
}
