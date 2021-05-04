package com.webDevelopment.turistar.HotelPlan.Domain.ValueObjects;

import com.webDevelopment.turistar.HotelPlan.Domain.Exceptions.InvalidPeopleNumber;
import com.webDevelopment.turistar.Shared.Domain.DoubleValueObject;

public class HotelPlanPeopleNumber extends DoubleValueObject {

    //TODO: Servicio para consultar que la ciudad existe

    public HotelPlanPeopleNumber(double number){
        this.validate(number);
        this.value = number;
    }

    private void validate(double number){
      if( number< 1 ){
          throw new InvalidPeopleNumber("Number less than 0");
      }
    }
}
