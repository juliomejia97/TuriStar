package com.webDevelopment.turistar.Shared.Domain.Exceptions;

public class LengthNotValid extends RuntimeException {
    public LengthNotValid(String message) {
        super(message);
    }
}
