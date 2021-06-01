package com.webDevelopment.turistar.Administrator.Hotel.Domain.Exceptions;

public class InvalidPhotoFormat extends RuntimeException {
    public InvalidPhotoFormat(String message) {
        super(message);
    }
}
