package com.webDevelopment.turistar.User.User.Domain.Exceptions;

public class UpperLowerError extends RuntimeException {
    public UpperLowerError(String message) {
        super(message);
    }
}