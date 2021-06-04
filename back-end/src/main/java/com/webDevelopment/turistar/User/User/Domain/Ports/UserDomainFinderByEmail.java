package com.webDevelopment.turistar.User.User.Domain.Ports;

import com.webDevelopment.turistar.User.User.Domain.Exceptions.UserNotExist;
import com.webDevelopment.turistar.User.User.Domain.User;

import java.util.Optional;

public class UserDomainFinderByEmail {
    private UserRepository repository;

    public UserDomainFinderByEmail(UserRepository repository) {
        this.repository = repository;
    }

    public Optional<User> execute(String userEmail) {
        Optional<User> user = repository.findByEmail(userEmail);

        if (user.isEmpty()) {
            throw new UserNotExist("User with Email: " + userEmail + " not exist");
        }

        return user;
    }
}

