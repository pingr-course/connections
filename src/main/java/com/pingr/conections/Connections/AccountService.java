package com.pingr.conections.Connections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Service
public class AccountService {
    private final AccountRepository repo;

    @Autowired
    public AccountService(AccountRepository repo) {
        this.repo = repo;
    }

    public void storeAccount(Account account) {
        this.repo.save(account);
        System.out.println("salvei a conta:");
        System.out.println(account);
    }

    public boolean stablishFriendshipBetween(Long aId, Long bId) {
        Optional<Account> aOptional = this.repo.findById(aId);
        Optional<Account> bOptional = this.repo.findById(bId);

        if (!aOptional.isPresent() || !bOptional.isPresent()) return false;

        Account a = aOptional.get();
        Account b = bOptional.get();

        Set<Account> aFriends = a.getFriends();
        aFriends.add(b);
        a.setFriends(aFriends);

        Set<Account> bFriends = b.getFriends();
        bFriends.add(a);
        b.setFriends(bFriends);

        this.repo.saveAll(List.of(a, b));

        return true;
    }
}
