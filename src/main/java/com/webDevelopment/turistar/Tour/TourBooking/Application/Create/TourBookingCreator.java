package com.webDevelopment.turistar.Tour.TourBooking.Application.Create;

import com.webDevelopment.turistar.Shared.Domain.Bus.Event.EventBus;
import com.webDevelopment.turistar.Shared.Domain.Tour.TourId;
import com.webDevelopment.turistar.Shared.Domain.TourBooking.TourBookingId;
import com.webDevelopment.turistar.Shared.Domain.User.UserId;
import com.webDevelopment.turistar.Tour.TourBooking.Domain.Ports.TourBookingRepository;
import com.webDevelopment.turistar.Tour.TourBooking.Domain.TourBooking;
import com.webDevelopment.turistar.Tour.TourBooking.Domain.ValueObjects.TourBookingEndDate;
import com.webDevelopment.turistar.Tour.TourBooking.Domain.ValueObjects.TourBookingInitDate;

import java.time.LocalDate;

public class TourBookingCreator {

    private TourBookingRepository repository;
    private EventBus eventBus;
    public TourBookingCreator(TourBookingRepository repository, EventBus eventBus) {
        this.repository = repository;
        this.eventBus = eventBus;
    }

    public void execute(String tourBookingId, LocalDate tourBookingInitDate, LocalDate tourBookingEndDate, String tourId, String userId)
    {
        TourBooking tourBooking = TourBooking.create(new TourBookingId(tourBookingId),
                new TourBookingInitDate(tourBookingInitDate), new TourBookingEndDate(tourBookingEndDate), new TourId(tourId),
                new UserId(userId));
        repository.save(tourBooking);
        eventBus.publish(tourBooking.pullDomainEvents());
    }

}
