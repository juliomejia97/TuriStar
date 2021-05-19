package com.webDevelopment.turistar.Administrator.City.Infrastructure.Events;

import com.webDevelopment.turistar.Administrator.City.Application.Update.UpdateTourSpot;
import com.webDevelopment.turistar.Shared.Domain.Bus.Event.DomainEventSubscriber;
import com.webDevelopment.turistar.Shared.Domain.TourSpot.TourSpotCreatedEventDomain;
import org.springframework.context.event.EventListener;

@DomainEventSubscriber(TourSpotCreatedEventDomain.class)
public class UpdateOnTourSpotCreated {
    private UpdateTourSpot updateTourSpot;

    public UpdateOnTourSpotCreated(UpdateTourSpot updateTourSpot) {
        this.updateTourSpot = updateTourSpot;
    }

    @EventListener
    public void on(TourSpotCreatedEventDomain event){
        updateTourSpot.execute(event.aggregateId(), event.getTourSpotName(),event.getLatitude(),event.getLongitude(),event.getDescription());
    }
}
