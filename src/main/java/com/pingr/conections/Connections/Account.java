package com.pingr.conections.Connections;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@JsonSerialize
public class Account {
    @Id
    private Long id;

    @Column(
            name = "username",
            nullable = false,
            unique = true
    )
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
        HashSet<Account> _friends = new HashSet<>();

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
                ", friends=" + friends +
                '}';
    }
}
