package com.webDevelopment.turistar.User.User.Domain.Exceptions;

public class UserNotExist extends RuntimeException {
    public UserNotExist(String message) {
        super(message);
    }
}