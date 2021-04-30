package com.webDevelopment.turistar.HotelPlan.Domain.Exceptions;

public class InvalidPeopleNumber extends RuntimeException {
    public InvalidPeopleNumber(String message) {
        super(message);
    }
}
