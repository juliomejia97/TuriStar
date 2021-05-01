package com.webDevelopment.turistar.Tour.Tour.Domain.ValueObjects;

import com.webDevelopment.turistar.Shared.Domain.DoubleValueObject;
import com.webDevelopment.turistar.Tour.Tour.Domain.Exceptions.NegativeNumber;

public class TourPrice extends DoubleValueObject {
    public TourPrice(double price){
        this.validate(price);
        this.value = price;
    }

    private void validate(double price){
        if( price < 0 ){
            throw new NegativeNumber("Price of a tour should be a positive decimal number");
        }
    }
}
