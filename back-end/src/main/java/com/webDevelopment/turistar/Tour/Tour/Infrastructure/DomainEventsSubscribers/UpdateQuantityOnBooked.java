package com.webDevelopment.turistar.Tour.Tour.Infrastructure.DomainEventsSubscribers;


import com.webDevelopment.turistar.Shared.Domain.Bus.Event.DomainEventSubscriber;
import com.webDevelopment.turistar.Shared.Domain.TourBooking.TourBookedEventDomain;
import com.webDevelopment.turistar.Tour.Tour.Application.Update.UpdateTourBookingQuantity;
import org.springframework.context.event.EventListener;

@DomainEventSubscriber(TourBookedEventDomain.class)
public class UpdateQuantityOnBooked {

    private UpdateTourBookingQuantity bookingQuantity;

    public UpdateQuantityOnBooked(UpdateTourBookingQuantity bookingQuantity) {
        this.bookingQuantity = bookingQuantity;
    }

    @EventListener
    public void on(TourBookedEventDomain event){
        if(event.getTourBookingId() ==null){
            bookingQuantity.execute(event.aggregateId());
        }
    }
}
