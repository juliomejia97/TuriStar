package com.webDevelopment.turistar.Tour.Tour.Domain.Exceptions;

public class TourDuplicated extends RuntimeException {
    public TourDuplicated(String message) {
        super(message);
    }
}
