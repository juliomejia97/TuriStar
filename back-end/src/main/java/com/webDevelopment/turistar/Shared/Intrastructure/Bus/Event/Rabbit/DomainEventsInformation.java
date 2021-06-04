package com.webDevelopment.turistar.Shared.Intrastructure.Bus.Event.Rabbit;

import com.webDevelopment.turistar.Shared.Domain.Bus.Event.DomainEvent;
import com.webDevelopment.turistar.Shared.Domain.Hotel.HotelCreatedDomainEvent;

import java.util.HashMap;

public class DomainEventsInformation {
    private final HashMap<String,Class<? extends DomainEvent>> indexDomainEvents =  new HashMap<>();
    private final HashMap<String,String> domainEventSubscriber = new HashMap<>();

    public DomainEventsInformation() {
        indexDomainEvents.put("hotel.created", HotelCreatedDomainEvent.class);
        domainEventSubscriber.put("webDevelopment.Turistar.Administrator.City.CityAddHotelonHotelCreated","addHotelOnHotelCreated");
    }
    public Class<? extends DomainEvent> getDomainEvent(String name){
        return indexDomainEvents.get(name);
    }

    public boolean validateEventSubscriber(String name){
        return domainEventSubscriber.containsKey(name);
    }

    public String getEventSubscriber(String name){
        return domainEventSubscriber.get(name);
    }
}
