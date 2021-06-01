package com.webDevelopment.turistar.Hotel.Ticket.Domain.ValueObjects;

import com.webDevelopment.turistar.Hotel.Ticket.Domain.Exceptions.LengthNotValid;
import com.webDevelopment.turistar.Shared.Domain.StringValueObject;

public class TicketAirline extends StringValueObject {

    //TODO: Servicio para consultar que la airline existe

    public TicketAirline() {
    }

    public TicketAirline(String name){
        this.validate(name);
        this.value = name;
    }

    private void validate(String name){
      if( name.length() < 1 ){
          throw new LengthNotValid("Number of characters invalid");
      }
    }
}
