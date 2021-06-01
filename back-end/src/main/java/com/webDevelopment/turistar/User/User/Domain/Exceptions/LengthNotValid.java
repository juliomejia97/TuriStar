package com.webDevelopment.turistar.User.User.Domain.Exceptions;

public class LengthNotValid extends RuntimeException {
    public LengthNotValid(String message) {
        super(message);
    }
}