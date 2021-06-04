package com.webDevelopment.turistar.User.User.Domain.Ports;


import com.webDevelopment.turistar.User.User.Domain.User;

import java.util.Optional;

public interface UserRepository {

    String getToken(String userEmail) throws Exception;
    void save(User user);

    Optional<User> find(String userId);

    void update(User user);
    Optional<User> findByEmail(String userEmail);
}