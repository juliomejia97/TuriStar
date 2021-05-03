package com.webDevelopment.turistar.User.User.Domain.Ports;


import com.webDevelopment.turistar.User.User.Domain.User;

import java.util.Optional;

public interface UserRepository {

    void save(User user);

    Optional<User> find(String userId);

    void update(String userId, User user);
}