package com.webDevelopment.turistar.Hotel.HotelPlanBooking.Application.Create;

import com.webDevelopment.turistar.Hotel.HotelPlanBooking.Domain.HotelPlanBooking;
import com.webDevelopment.turistar.Hotel.HotelPlanBooking.Domain.Ports.HotelPlanBookingRepository;
import com.webDevelopment.turistar.Hotel.HotelPlanBooking.Domain.ValueObjects.HotelPlanBookingEndDate;
import com.webDevelopment.turistar.Hotel.HotelPlanBooking.Domain.ValueObjects.HotelPlanBookingInitDate;
import com.webDevelopment.turistar.Shared.Domain.Bus.Event.EventBus;
import com.webDevelopment.turistar.Shared.Domain.HotelPlanBooking.HotelPlanBookingId;
import com.webDevelopment.turistar.Shared.Domain.User.UserId;

import java.time.LocalDate;

public class HotelPlanBookingCreator {

    private HotelPlanBookingRepository repository;

    public HotelPlanBookingCreator(HotelPlanBookingRepository repository) {
        this.repository = repository;
    }

    public void execute(String hotelPlanBookingId, String userId, LocalDate hotelPlanBookingInitDate, LocalDate hotelPlanBookingEndDate){
        HotelPlanBooking hotelPlanBooking = HotelPlanBooking.create(new HotelPlanBookingId(hotelPlanBookingId), new UserId(userId), new HotelPlanBookingInitDate(hotelPlanBookingInitDate), new HotelPlanBookingEndDate(hotelPlanBookingEndDate));
        repository.save(hotelPlanBooking);
    }
}
