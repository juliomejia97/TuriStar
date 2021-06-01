package com.webDevelopment.turistar.Hotel.HotelPlan.Domain.ValueObjects;

import com.webDevelopment.turistar.Hotel.HotelPlan.Domain.Exceptions.InvalidPrice;
import com.webDevelopment.turistar.Shared.Domain.DoubleValueObject;

public class HotelPlanPrice extends DoubleValueObject {
    public HotelPlanPrice() {
    }

    public HotelPlanPrice(double price){
        this.validate(price);
        this.value = price;
    }

    private void validate(double price){
      if( price< 1 ){
          throw new InvalidPrice("Price less than 0");
      }
    }
}
