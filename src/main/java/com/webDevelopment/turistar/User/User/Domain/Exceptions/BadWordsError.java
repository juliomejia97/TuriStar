package com.webDevelopment.turistar.User.User.Domain.Exceptions;

public class BadWordsError extends RuntimeException {
    public BadWordsError(String mesagge) {
        super(mesagge);
    }
}