package com.webDevelopment.turistar.Hotel.HotelPlanBooking.Domain;

import com.webDevelopment.turistar.Hotel.HotelPlanBooking.Domain.Exceptions.HotelPlanBookingAlreadyDeleted;
import com.webDevelopment.turistar.Hotel.HotelPlanBooking.Domain.ValueObjects.*;
import com.webDevelopment.turistar.Shared.Domain.HotelPlanBooking.HotelPlanBookingId;
import com.webDevelopment.turistar.Shared.Domain.User.UserId;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Objects;
import java.util.Optional;

public class HotelPlanBooking {

    private HotelPlanBookingId hotelPlanBookingId;
    private UserId userId;

    private HotelPlanBookingInitDate hotelPlanBookingInitDate;
    private HotelPlanBookingEndDate hotelPlanBookingEndDate;

    private HotelPlanBookingActive hotelPlanBookingActive ;

    private Optional<TicketDetail> ticketDetail;
    private Optional<HotelPlanDetail> hotelPlanDetail;

    private HotelPlanBooking(){}

    public HotelPlanBooking(HotelPlanBookingId hotelPlanBookingId,UserId userId,HotelPlanBookingInitDate hotelPlanBookingInitDate,HotelPlanBookingEndDate hotelPlanBookingEndDate) {
        this.hotelPlanBookingId = hotelPlanBookingId;
        this.userId = userId;
        this.hotelPlanBookingInitDate = hotelPlanBookingInitDate;
        this.hotelPlanBookingEndDate = hotelPlanBookingEndDate;
        this.hotelPlanBookingActive= new HotelPlanBookingActive(true);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HotelPlanBooking hotelPlanBooking = (HotelPlanBooking) o;
        return Objects.equals(hotelPlanBookingId, hotelPlanBooking.hotelPlanBookingId) &&
                Objects.equals(userId, hotelPlanBooking.userId) &&
                Objects.equals(hotelPlanBookingInitDate, hotelPlanBooking.hotelPlanBookingInitDate) &&
                Objects.equals(hotelPlanBookingEndDate, hotelPlanBooking.hotelPlanBookingEndDate) &&
                Objects.equals(hotelPlanBookingActive, hotelPlanBooking.hotelPlanBookingActive);
    }

    public HashMap<String, String> data()
    {
        return new HashMap<>() {{
            put("id", hotelPlanBookingId.value());
            put("userId", userId.value());
            put("hotelPlanBookingInitDate", hotelPlanBookingInitDate.value().toString());
            put("hotelPlanBookingEndDate", hotelPlanBookingEndDate.value().toString());
            put("hotelPlanBookingActive", hotelPlanBookingActive.value().toString());
        }};
    }

    public void updateHotelPlanBooking(LocalDate hotelPlanBookingInitDate, LocalDate hotelPlanBookingEndDate){
        this.hotelPlanBookingInitDate = new HotelPlanBookingInitDate(hotelPlanBookingInitDate);
        this.hotelPlanBookingEndDate = new HotelPlanBookingEndDate(hotelPlanBookingEndDate);
    }

    public void deleteHotelPlanBooking(){
        if(!this.hotelPlanBookingActive.value()){
            throw new HotelPlanBookingAlreadyDeleted("The Hotel Plan Booking has been already deleted");
        }
        this.hotelPlanBookingActive = new HotelPlanBookingActive(false);
    }
    public boolean equalsbyId(String hotelPlanBookingId){
        return this.hotelPlanBookingId.equals(new HotelPlanBookingId(hotelPlanBookingId));
    }


}
