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
    private final AccountService accountService;

    @Autowired
    public ConnectionsController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping(path = "/{aid}/{bid}")
    public boolean addFriends(@PathVariable("aid") Long aid, @PathVariable("bid") Long bid) {
        return this.accountService.stablishFriendshipBetween(aid, bid);
    }
}
