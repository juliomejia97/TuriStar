package com.webDevelopment.turistar.Administrator.Hotel.Domain.ValueObjects;

import com.webDevelopment.turistar.Administrator.Hotel.Domain.Exceptions.InvalidHotelRanking;
import com.webDevelopment.turistar.Shared.Domain.DoubleValueObject;

public class HotelStars extends DoubleValueObject {
    public HotelStars(Double ranking) {
        this.validate(ranking);
        this.value=ranking;
    }
    private void validate(Double ranking){
        if(ranking<0||ranking>5){
            throw new InvalidHotelRanking("The Hotel Stars are not valid, this must be an integer number between 0 and 5");
        }
    }
    private HotelStars(){

    }
}
