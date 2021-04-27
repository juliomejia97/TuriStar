package com.webDevelopment.turistar.Administrator.City.Domain.ValueObjects;

import com.webDevelopment.turistar.Administrator.City.Domain.Exceptions.LengthNotValid;
import com.webDevelopment.turistar.Shared.Domain.StringValueObject;

public class CityName extends StringValueObject {

    //TODO: Servicio para consultar que la ciudad existe

    public CityName(String name){
        this.validate(name);
        this.value = name;
    }

    private void validate(String name){
      if( name.length() < 1 ){
          throw new LengthNotValid("Number of characters invalid");
      }
    }
}
