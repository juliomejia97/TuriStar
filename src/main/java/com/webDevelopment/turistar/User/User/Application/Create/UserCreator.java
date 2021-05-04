package com.webDevelopment.turistar.User.User.Application.Create;

import com.webDevelopment.turistar.Shared.Domain.User.UserId;
import com.webDevelopment.turistar.User.User.Domain.Exceptions.UserAlreadyExists;
import com.webDevelopment.turistar.User.User.Domain.Exceptions.UserNotExist;
import com.webDevelopment.turistar.User.User.Domain.Ports.UserDomainFinder;
import com.webDevelopment.turistar.User.User.Domain.Ports.UserRepository;
import com.webDevelopment.turistar.User.User.Domain.Ports.UserValidateWords;
import com.webDevelopment.turistar.User.User.Domain.Ports.ValidateWordService;
import com.webDevelopment.turistar.User.User.Domain.User;
import com.webDevelopment.turistar.User.User.Domain.ValueObjects.UserEmail;
import com.webDevelopment.turistar.User.User.Domain.ValueObjects.UserLastName;
import com.webDevelopment.turistar.User.User.Domain.ValueObjects.UserName;
import com.webDevelopment.turistar.User.User.Domain.ValueObjects.UserPassword;

import java.util.Optional;


public class UserCreator {
    private UserRepository repository;
    private ValidateWordService service;
    private UserValidateWords validator;
    private UserDomainFinder finder;

    public UserCreator(UserRepository repository, ValidateWordService service) {
        this.repository = repository;
        this.service = service;
        this.validator = new UserValidateWords(service);
        this.finder = new UserDomainFinder(repository);
    }

    public void execute(String userId, String userFirstName, String userLastName, String userEmail, String userPassword)
    {
        this.validate(userId);
        validator.execute(new UserEmail(userEmail).value());
        User user = new User(new UserId(userId), new UserName(userFirstName), new UserLastName(userLastName) , new UserEmail(userEmail),new UserPassword(userPassword));
        repository.save(user);
    }

    private void validate(String UserId)
    {
        try
        {

            Optional<User> user = this.finder.execute(UserId);
            if(!user.isEmpty())
            {
                throw new UserAlreadyExists("User with id: " + UserId + " already exist");
            }
        }
        catch (UserNotExist exception) {

        }
    }
}