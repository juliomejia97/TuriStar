package com.webDevelopment.turistar.Administrator.City.Infrastructure.DomainEventsSubscribers;

import com.webDevelopment.turistar.Administrator.City.Application.Create.CityAddTourSpot;
import com.webDevelopment.turistar.Shared.Domain.Bus.Event.DomainEventSubscriber;
import com.webDevelopment.turistar.Shared.Domain.TourSpot.TourSpotCreatedEventDomain;
import org.springframework.context.event.EventListener;

@DomainEventSubscriber(TourSpotCreatedEventDomain.class)
public class AddTourSpotOnTourSpotCreated {
    private CityAddTourSpot cityAddTourSpot;

    public AddTourSpotOnTourSpotCreated(CityAddTourSpot cityAddTourSpot) {
        this.cityAddTourSpot = cityAddTourSpot;
    }

    @EventListener
    public void on(TourSpotCreatedEventDomain event){
        cityAddTourSpot.execute(event.aggregateId(), event.getTourSpotId(),
                event.getTourSpotName(),event.getLatitude(),event.getLongitude(),event.getDescription());
    }
}
