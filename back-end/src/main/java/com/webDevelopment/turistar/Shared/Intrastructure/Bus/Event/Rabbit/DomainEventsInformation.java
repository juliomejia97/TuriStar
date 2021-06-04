package com.webDevelopment.turistar.Shared.Intrastructure.Bus.Event.Rabbit;

import com.webDevelopment.turistar.Shared.Domain.Bus.Event.DomainEvent;
import com.webDevelopment.turistar.Shared.Domain.Hotel.HotelCreatedDomainEvent;
import com.webDevelopment.turistar.Shared.Domain.TourSpot.TourSpotCreatedEventDomain;

import java.util.HashMap;

public class DomainEventsInformation {
    private final HashMap<String,Class<? extends DomainEvent>> indexDomainEvents =  new HashMap<>();
    private final HashMap<String,String> domainEventSubscriber = new HashMap<>();

    public DomainEventsInformation() {
        indexDomainEvents.put("hotel.created", HotelCreatedDomainEvent.class);
        indexDomainEvents.put("tourSpot.created", TourSpotCreatedEventDomain.class);
        domainEventSubscriber.put("webDevelopment.Turistar.Administrator.City.CityAddHotelonHotelCreated","addHotelOnHotelCreated");
        domainEventSubscriber.put("webDevelopment.Turistar.Administrator.City.CityAddTourSpotOnTourSpotCreated","addTourSpotOnTourSpotCreated");
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
