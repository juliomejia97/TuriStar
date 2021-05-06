package com.webDevelopment.turistar.Administrator.Hotel.Domain.ValueObjects;

import com.webDevelopment.turistar.Administrator.Hotel.Domain.Exceptions.InvalidHotelName;
import com.webDevelopment.turistar.Shared.Domain.StringValueObject;

public class HotelName extends StringValueObject {

    public HotelName(String hotelName) {
        this.validate(hotelName);
        this.value = hotelName;
    }

    private void validate(String hotelName){
        if(hotelName.length()<1){
            throw new InvalidHotelName("The hotel name is empty");
        }
    }

    private HotelName() {
    }
}
