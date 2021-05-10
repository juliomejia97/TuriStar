package com.webDevelopment.turistar.Hotel.HotelPlanBooking.Infrastructure;

import com.webDevelopment.turistar.Hotel.HotelPlanBooking.Domain.Ports.HotelPlanBookingRepository;
import com.webDevelopment.turistar.Hotel.HotelPlanBooking.Domain.HotelPlanBooking;
import com.webDevelopment.turistar.Hotel.HotelPlanBooking.Domain.ValueObjects.HotelPlanBookingEndDate;
import com.webDevelopment.turistar.Hotel.HotelPlanBooking.Domain.ValueObjects.HotelPlanBookingInitDate;

import com.webDevelopment.turistar.Shared.Domain.HotelPlanBooking.HotelPlanBookingId;
import com.webDevelopment.turistar.Shared.Domain.User.UserId;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryHotelPlanBookingRepository implements HotelPlanBookingRepository {

    private HotelPlanBooking hotelPlanBooking1 = new HotelPlanBooking(new HotelPlanBookingId("a0619482-a621-11eb-bcbc-0242ac130002"),new UserId("a0619482-a621-11eb-bcbc-0242ac130002"),new HotelPlanBookingInitDate(LocalDate.of(2022, 1, 8)),new HotelPlanBookingEndDate(LocalDate.of(2022, 1, 20)));
    private HotelPlanBooking hotelPlanBooking2 = new HotelPlanBooking(new HotelPlanBookingId("a06197e8-a621-11eb-bcbc-0242ac130002"),new UserId("a0619482-a621-11eb-bcbc-0242ac130002"),new HotelPlanBookingInitDate(LocalDate.of(2022, 1, 8)),new HotelPlanBookingEndDate(LocalDate.of(2022, 1, 20)));
    private HotelPlanBooking hotelPlanBooking3 = new HotelPlanBooking(new HotelPlanBookingId("a06198e2-a621-11eb-bcbc-0242ac130002"),new UserId("a0619482-a621-11eb-bcbc-0242ac130002"),new HotelPlanBookingInitDate(LocalDate.of(2022, 1, 8)),new HotelPlanBookingEndDate(LocalDate.of(2022, 1, 20)));
    private List<HotelPlanBooking> hotelPlanBookings = new ArrayList<>(){{
        add(hotelPlanBooking1);
        add(hotelPlanBooking2);
        add(hotelPlanBooking3);
    }};

    @Override
    public void update(HotelPlanBooking hotelPlanBooking) {
        this.hotelPlanBookings.remove(hotelPlanBooking);
        this.hotelPlanBookings.add(hotelPlanBooking);
    }

    @Override
    public Optional<HotelPlanBooking> find(String hotelPlanBookingId) {
        return hotelPlanBookings.stream().filter(hotelPlanBooking -> hotelPlanBooking.equalsbyId(hotelPlanBookingId)).findFirst();
    }

    @Override
    public void save(HotelPlanBooking hotelPlanBooking) {
        this.hotelPlanBookings.add(hotelPlanBooking);
    }

    @Override
    public Optional<List<HotelPlanBooking>> all() {

        return Optional.ofNullable(this.hotelPlanBookings);
    }
}
