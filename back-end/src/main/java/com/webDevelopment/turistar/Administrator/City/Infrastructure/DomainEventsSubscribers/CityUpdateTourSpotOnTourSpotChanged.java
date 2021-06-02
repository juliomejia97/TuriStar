package com.webDevelopment.turistar.Administrator.City.Infrastructure.DomainEventsSubscribers;

import com.webDevelopment.turistar.Administrator.City.Application.Update.CityUpdateTourSpots;
import com.webDevelopment.turistar.Shared.Domain.Bus.Event.DomainEventSubscriber;
import com.webDevelopment.turistar.Shared.Domain.TourSpot.TourSpotUpdatedDomainEvent;
import org.springframework.context.event.EventListener;

@DomainEventSubscriber(TourSpotUpdatedDomainEvent.class)
public class CityUpdateTourSpotOnTourSpotChanged {
    private CityUpdateTourSpots updateTourSpots;

    public CityUpdateTourSpotOnTourSpotChanged(CityUpdateTourSpots updateTourSpots) {
        this.updateTourSpots = updateTourSpots;
    }

    @EventListener
    public void on(TourSpotUpdatedDomainEvent event){
        if(!event.getTourEventType()){
            updateTourSpots.execute(event.aggregateId(),event.getTourSpotId(),event.getTourSpotName(),
                    event.getLatitude(),event.getLongitude(),event.getDescription(), event.getTourSpotPhotos());
        }
    }
}
