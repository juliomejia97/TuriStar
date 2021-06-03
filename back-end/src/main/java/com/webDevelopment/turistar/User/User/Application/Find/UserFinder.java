package com.webDevelopment.turistar.User.User.Application.Find;


import com.webDevelopment.turistar.Shared.Domain.User.UserId;
import com.webDevelopment.turistar.User.User.Domain.Ports.UserDomainFinderByEmail;
import com.webDevelopment.turistar.User.User.Domain.Ports.UserDomainFinderById;
import com.webDevelopment.turistar.User.User.Domain.Ports.UserRepository;
import com.webDevelopment.turistar.User.User.Domain.User;
import com.webDevelopment.turistar.User.User.Domain.ValueObjects.UserEmail;

import java.util.Optional;

public class UserFinder {

    private UserDomainFinderByEmail finder;

    public UserFinder(UserRepository repository) {
        this.finder = new UserDomainFinderByEmail(repository);
    }

    public User execute(String userEmail) {
        Optional<User> user = finder.execute(new UserEmail(userEmail).value());
        return user.get();
    }
}