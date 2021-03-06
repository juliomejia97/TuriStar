package com.webDevelopment.turistar.Tour.TourBooking.Domain;

import com.webDevelopment.turistar.Shared.Domain.Aggregate.AggregateRoot;
import com.webDevelopment.turistar.Shared.Domain.TourBooking.TourBookedEventDomain;
import com.webDevelopment.turistar.Shared.Domain.Tour.TourId;
import com.webDevelopment.turistar.Shared.Domain.TourBooking.TourBookingId;
import com.webDevelopment.turistar.Shared.Domain.User.UserId;
import com.webDevelopment.turistar.Tour.TourBooking.Domain.ValueObjects.TourBookingActive;
import com.webDevelopment.turistar.Tour.TourBooking.Domain.ValueObjects.TourBookingEndDate;
import com.webDevelopment.turistar.Tour.TourBooking.Domain.ValueObjects.TourBookingInitDate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.HashMap;

public class TourBooking extends AggregateRoot {

    TourBookingId tourBookingId;
    TourBookingInitDate tourBookingInitDate;
    TourBookingEndDate tourBookingEndDate;
    TourBookingActive tourBookingActive;
    TourId tourId;
    UserId userId;

    public TourBooking(TourBookingId tourBookingId, TourBookingInitDate tourBookingInitDate, TourBookingEndDate tourBookingEndDate, TourId tourId, UserId userId) {
        this.tourBookingId = tourBookingId;
        this.tourId = tourId;
        this.userId = userId;
        this.tourBookingInitDate = tourBookingInitDate;
        this.tourBookingEndDate = tourBookingEndDate;
        this.tourBookingActive = new TourBookingActive(true);
    }

    public static TourBooking create(TourBookingId tourBookingId, TourBookingInitDate tourBookingInitDate, TourBookingEndDate tourBookingEndDate, TourId tourId, UserId userId){
        TourBookingActive active = new TourBookingActive(true);
        TourBooking tourBooking =  new TourBooking(tourBookingId,tourBookingInitDate,tourBookingEndDate,tourId,userId);
        tourBooking.record(new TourBookedEventDomain(userId.value(),
                tourId.value(),
                tourBooking.formatDate(tourBookingInitDate.value()),
                tourBooking.formatDate(tourBookingEndDate.value())));
        tourBooking.record(new TourBookedEventDomain(tourId.value(),
                null, null, null));
        return tourBooking;
    }

    public void deleteTourBooking() {
        tourBookingActive = new TourBookingActive(false);
    }

    public HashMap<String, Object> data()
    {
        HashMap<String, Object> data = new HashMap<>() {{
            put("id", tourBookingId.value());
            put("tourBookingInitDate", tourBookingInitDate.value());
            put("tourBookingEndDate", tourBookingEndDate.value());
            put("tourBookingActive", tourBookingActive.value());
        }};
        return data;
    }

    //TODO: Formatear la fecha para devovler crear el JSON
    private String formatDate(LocalDate date){
        return date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL));
    }
    private TourBooking(){}
}
