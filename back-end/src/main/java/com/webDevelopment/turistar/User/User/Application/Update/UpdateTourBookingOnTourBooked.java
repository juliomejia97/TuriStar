package com.webDevelopment.turistar.User.User.Application.Update;

import com.webDevelopment.turistar.Shared.Domain.Bus.Event.DomainEventSubscriber;
import com.webDevelopment.turistar.Shared.Domain.Tour.TourBookedEventDomain;
import org.springframework.context.event.EventListener;

@DomainEventSubscriber({TourBookedEventDomain.class})
public class UpdateTourBookingOnTourBooked {

    private UpdateTourBooking updateTourBooking;

    public UpdateTourBookingOnTourBooked(UpdateTourBooking updateTourBooking) {
        this.updateTourBooking = updateTourBooking;
    }

    @EventListener
    public void on(TourBookedEventDomain event){
        updateTourBooking.execute(event.aggregateId(),event.getTourBookingId(),event.getTourBookingInitDate(),
                event.getTourBookingEndDate(),event.getTourBookingActive());
    }
}
