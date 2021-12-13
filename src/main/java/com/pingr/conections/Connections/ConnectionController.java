package com.pingr.conections.Connections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/connections")
public class ConnectionController {
    private final AccountService accountService;

    @Autowired
    public ConnectionController(AccountService accountService) {
        this.accountService = accountService;
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
}
