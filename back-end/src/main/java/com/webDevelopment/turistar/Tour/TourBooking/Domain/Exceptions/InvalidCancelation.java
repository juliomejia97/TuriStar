package com.webDevelopment.turistar.Tour.TourBooking.Domain.Exceptions;

public class InvalidCancelation extends RuntimeException {
    public InvalidCancelation(String message) {
        super(message);
    }
}
