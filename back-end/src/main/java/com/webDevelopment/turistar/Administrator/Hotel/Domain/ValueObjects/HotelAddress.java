package com.webDevelopment.turistar.Administrator.Hotel.Domain.ValueObjects;

import com.webDevelopment.turistar.Administrator.Hotel.Domain.Exceptions.InvalidHotelAddress;
import com.webDevelopment.turistar.Shared.Domain.StringValueObject;

public class HotelAddress extends StringValueObject {

    public HotelAddress(String address) {
        this.validate(address);
        this.value=address;
    }
    private void validate(String address){
        if(address.length()<1){
            throw new InvalidHotelAddress("The Address of the hotel is empty");
        }
    }
    private HotelAddress(){}
}
