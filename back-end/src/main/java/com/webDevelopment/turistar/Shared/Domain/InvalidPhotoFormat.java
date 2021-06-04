package com.webDevelopment.turistar.Shared.Domain;

public class InvalidPhotoFormat extends RuntimeException {
    public InvalidPhotoFormat(String message) {
        super(message);
    }
}
