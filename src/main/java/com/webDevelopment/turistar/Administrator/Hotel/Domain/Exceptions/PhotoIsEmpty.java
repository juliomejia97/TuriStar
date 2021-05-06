package com.webDevelopment.turistar.Administrator.Hotel.Domain.Exceptions;

public class PhotoIsEmpty extends RuntimeException {
    public PhotoIsEmpty(String message) {
        super(message);
    }
}
