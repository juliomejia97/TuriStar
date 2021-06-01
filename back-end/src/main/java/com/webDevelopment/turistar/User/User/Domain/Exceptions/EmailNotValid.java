package com.webDevelopment.turistar.User.User.Domain.Exceptions;

public class EmailNotValid extends RuntimeException {
    public EmailNotValid(String message) {
        super(message);
    }
}
