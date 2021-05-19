package com.webDevelopment.turistar.Tour.Tour.Infrastructure.DomainEventsSubscribers;

import com.webDevelopment.turistar.Shared.Domain.Bus.Event.DomainEventSubscriber;
import com.webDevelopment.turistar.Shared.Domain.TourSpot.TourSpotUpdatedDomainEvent;
import org.springframework.context.event.EventListener;

@DomainEventSubscriber(TourSpotUpdatedDomainEvent.class)
public class TourUpdateTourSpotOnChanged {


    @EventListener
    public void on(TourSpotUpdatedDomainEvent event){
        if(event.getTourEventType()){
            System.out.println("Tour.UpdateTourSpotOnTourSpotChanged \n Llegó el evento, cambió el Tour Spot: "
                    +event.getTourSpotName()+" se debe cambiar la Tour: "+event.aggregateId());
        }
    }
}
