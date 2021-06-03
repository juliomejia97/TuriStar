package com.webDevelopment.turistar.Tour.Tour.Domain.Exceptions;

public class TourDescriptionError extends RuntimeException {
    public TourDescriptionError(String message) {
        super(message);
    }
}
