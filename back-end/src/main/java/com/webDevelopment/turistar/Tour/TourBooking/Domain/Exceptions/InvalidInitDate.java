package com.webDevelopment.turistar.Tour.TourBooking.Domain.Exceptions;

public class InvalidInitDate extends RuntimeException{
    public InvalidInitDate(String message) {
        super(message);
    }
}
