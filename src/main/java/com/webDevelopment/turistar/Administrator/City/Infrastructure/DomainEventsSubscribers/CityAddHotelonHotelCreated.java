package com.webDevelopment.turistar.Administrator.City.Infrastructure.DomainEventsSubscribers;

import com.webDevelopment.turistar.Administrator.City.Application.Create.CityAddHotel;
import com.webDevelopment.turistar.Shared.Domain.Bus.Event.DomainEventSubscriber;
import com.webDevelopment.turistar.Shared.Domain.Hotel.HotelCreatedDomainEvent;
import org.springframework.context.event.EventListener;

@DomainEventSubscriber(HotelCreatedDomainEvent.class)
public class CityAddHotelonHotelCreated {

    private CityAddHotel addHotel;

    public CityAddHotelonHotelCreated(CityAddHotel addHotel) {
        this.addHotel = addHotel;
    }

    @EventListener
    public void on(HotelCreatedDomainEvent event){
        addHotel.execute(event.aggregateId(), event.getHotelId(),event.getHotelName(),event.getHotelAddress(),
                event.getHotelStars(), event.getHotelPhotos());
    }
}
