package com.webDevelopment.turistar.Administrator.City.Infrastructure.DomainEventsSubscribers;


import com.webDevelopment.turistar.Administrator.City.Application.Update.CityUpdateHotel;
import com.webDevelopment.turistar.Shared.Domain.Bus.Event.DomainEventSubscriber;
import com.webDevelopment.turistar.Shared.Domain.Hotel.HotelUpdatedDomainEvent;
import org.springframework.context.event.EventListener;

@DomainEventSubscriber(HotelUpdatedDomainEvent.class)
public class CityUpdateHotelsOnHotelChanged {
    private CityUpdateHotel updateHotel;

    public CityUpdateHotelsOnHotelChanged(CityUpdateHotel updateHotel) {
        this.updateHotel = updateHotel;
    }

    @EventListener
    public void on(HotelUpdatedDomainEvent event){
        updateHotel.execute(event.aggregateId(),event.getHotelId(),event.getHotelName(),
                event.getHotelStars(),event.getHotelAddress(),event.getHotelPhotos());
    }
}
