package com.webDevelopment.turistar.User.User.Application.Login;

import com.webDevelopment.turistar.User.User.Domain.Ports.UserDomainFinderByEmail;
import com.webDevelopment.turistar.User.User.Domain.Ports.UserDomainFinderById;
import com.webDevelopment.turistar.User.User.Domain.Ports.UserRepository;
import com.webDevelopment.turistar.User.User.Domain.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

public class UserLogger {
    private UserRepository repository;
    private UserDomainFinderByEmail finder;

    public UserLogger(UserRepository repository)
    {
        this.repository = repository;
        this.finder = new UserDomainFinderByEmail(repository);
    }

    public boolean execute(String userEmail, String userPassword)
    {
        Optional<User> user = this.repository.findByEmail(userEmail);
        if(!user.isEmpty())
        {
            User currentUser = user.get();
            return currentUser.authPassword(userPassword);
        }
        return false;

    }
    public String getToken(String userEmail) throws Exception {
        return repository.getToken(userEmail);
    }

}
