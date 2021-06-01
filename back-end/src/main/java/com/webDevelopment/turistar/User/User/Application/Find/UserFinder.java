package com.webDevelopment.turistar.User.User.Application.Find;


import com.webDevelopment.turistar.Shared.Domain.User.UserId;
import com.webDevelopment.turistar.User.User.Domain.Ports.UserDomainFinder;
import com.webDevelopment.turistar.User.User.Domain.Ports.UserRepository;
import com.webDevelopment.turistar.User.User.Domain.User;

import java.util.Optional;

public class UserFinder {

    private UserDomainFinder finder;

    public UserFinder(UserRepository repository) {
        this.finder = new UserDomainFinder(repository);
    }

    public User execute(String userId) {
        Optional<User> user = finder.execute(new UserId(userId).value());
        return user.get();
    }
}