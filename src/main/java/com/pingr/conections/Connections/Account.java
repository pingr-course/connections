package com.pingr.conections.Connections;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Account {
    @Id
    @JsonProperty("id")
    private Long id;

    @Column(
            name = "username",
            nullable = false,
            unique = true
    )
    @JsonProperty("username")
    private String username;

    @OneToMany
    private Set<Account> friends = new HashSet<>();

    public Account(Long id, String username, Set<Account> friends) {
        this.id = id;
        this.username = username;
        this.friends = friends;
    }

    public Account() {
    }

    public void addFriend(Account account) {
        this.friends.add(account);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Account> getFriends() {
        Set<Account> _friends = new HashSet<>();
        for (Account friend: this.friends) {
            _friends.add(new Account(friend.getId(), friend.getUsername(), new HashSet<>()));
        }

        return _friends;
    }

    public void setFriends(Set<Account> friends) {
        this.friends = friends;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", friends=" + this.getFriends() +
                '}';
    }
}
