package com.webDevelopment.turistar.User.User.Application.Update;



import com.webDevelopment.turistar.User.User.Domain.Ports.UserDomainFinder;
import com.webDevelopment.turistar.User.User.Domain.Ports.UserRepository;
import com.webDevelopment.turistar.User.User.Domain.Ports.UserValidateWords;
import com.webDevelopment.turistar.User.User.Domain.Ports.ValidateWordService;
import com.webDevelopment.turistar.User.User.Domain.User;
import com.webDevelopment.turistar.User.User.Domain.ValueObjects.UserEmail;
import com.webDevelopment.turistar.User.User.Domain.ValueObjects.UserLastName;
import com.webDevelopment.turistar.User.User.Domain.ValueObjects.UserName;

import java.util.Optional;

public class UserModifier {

    private UserRepository repository;
    private UserDomainFinder finder;
    private UserValidateWords validator;
    private ValidateWordService service;

    public UserModifier(UserRepository repository, ValidateWordService service) {
        this.repository = repository;
        this.service = service;
        this.finder = new UserDomainFinder(repository);
        this.validator = new UserValidateWords(service);
    }

    public void execute(String userId, String userName, String userLastName, String userEmail)
    {
        validator.execute(new UserEmail(userEmail).value());
        Optional<User> actualUser = finder.execute(userId);
        User oldUser = actualUser.get();
        oldUser.updateUser(new UserName(userName), new UserLastName(userLastName), new UserEmail(userEmail));
        repository.update(oldUser);
    }
}