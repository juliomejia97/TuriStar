package com.webDevelopment.turistar.Shared.Domain;

public class BadInfoError extends RuntimeException {
    public BadInfoError(String message) {
        super(message);
    }
}
