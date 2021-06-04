package com.webDevelopment.turistar.User.User.Domain.Ports;

import com.webDevelopment.turistar.User.User.Domain.Exceptions.UserNotExist;
import com.webDevelopment.turistar.User.User.Domain.User;

import java.util.Optional;

public class UserDomainFinderById {

    private UserRepository repository;

    public UserDomainFinderById(UserRepository repository) {
        this.repository = repository;
    }

    public Optional<User> execute(String userId) {
        Optional<User> user = repository.find(userId);

        if (user.isEmpty()) {
            throw new UserNotExist("User with id: " + userId + " not exist");
        }

        return user;
    }
}