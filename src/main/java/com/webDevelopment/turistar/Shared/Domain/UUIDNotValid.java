package com.webDevelopment.turistar.Shared.Domain;

public class UUIDNotValid extends RuntimeException {
    public UUIDNotValid(String message) {
        super(message);
    }
}