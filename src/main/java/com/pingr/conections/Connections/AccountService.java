package com.pingr.conections.Connections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void stablishFriendshipBetween(Long aId, Long bId) {
        Optional<Account> aOptional = this.accountRepository.findById(aId);
        Optional<Account> bOptional= this.accountRepository.findById(bId);

        if (!aOptional.isPresent() || !bOptional.isPresent()) throw new RuntimeException("not found");

        Account a = aOptional.get();
        Account b = bOptional.get();

        a.addFriend(b);
        b.addFriend(a);

        this.accountRepository.saveAll(List.of(a, b));
    }

    public Account findOne(Long id) {
        Optional<Account> accountOptional = this.accountRepository.findById(id);

        if (!accountOptional.isPresent()) throw new RuntimeException("not found");

        return accountOptional.get();
    }
}
