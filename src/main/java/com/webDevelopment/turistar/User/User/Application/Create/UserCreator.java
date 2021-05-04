package com.webDevelopment.turistar.User.User.Application.Create;

import com.webDevelopment.turistar.Shared.Domain.User.UserId;
import com.webDevelopment.turistar.User.User.Domain.Exceptions.UserNotExist;
import com.webDevelopment.turistar.User.User.Domain.Ports.UserDomainFinder;
import com.webDevelopment.turistar.User.User.Domain.Ports.UserValidateWords;
import com.webDevelopment.turistar.User.User.Domain.User;
import com.webDevelopment.turistar.User.User.Domain.ValueObjects.UserEmail;
import com.webDevelopment.turistar.User.User.Domain.ValueObjects.UserLastName;
import com.webDevelopment.turistar.User.User.Domain.ValueObjects.UserName;
import com.webDevelopment.turistar.User.User.Domain.ValueObjects.UserPassword;
import com.webDevelopment.turistar.User.User.Infrastructure.BadWordsService;
import com.webDevelopment.turistar.User.User.Infrastructure.InMemoryUserRepository;


public class UserCreator {
    private InMemoryUserRepository inMemoryUserRepository;
    private BadWordsService badWordsService;
    private UserValidateWords validator;
    private UserDomainFinder finder;

    public UserCreator(InMemoryUserRepository inMemoryUserRepository, BadWordsService badWordsService) {
        this.inMemoryUserRepository = inMemoryUserRepository;
        this.badWordsService = badWordsService;
        this.validator = new UserValidateWords(badWordsService);
        this.finder = new UserDomainFinder(inMemoryUserRepository);
    }

    public void execute(String userId, String userFirstName, String userLastName, String userEmail, String userPassword)
    {
        this.validate(userId);
        validator.execute(new UserEmail(userEmail).value());


        User user = new User(new UserId(userId), new UserName(userFirstName), new UserLastName(userLastName) , new UserEmail(userEmail),new UserPassword(userPassword));
        inMemoryUserRepository.save(user);
    }

    private void validate(String UserId)
    {
        try
        {
            this.finder.execute(UserId);
        }
        catch (UserNotExist exception) { }
    }
}