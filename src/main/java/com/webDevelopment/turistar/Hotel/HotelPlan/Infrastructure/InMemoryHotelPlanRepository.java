package com.webDevelopment.turistar.Hotel.HotelPlan.Infrastructure;

import com.webDevelopment.turistar.Hotel.HotelPlan.Domain.HotelPlan;
import com.webDevelopment.turistar.Hotel.HotelPlan.Domain.Ports.HotelPlanRepository;
import com.webDevelopment.turistar.Hotel.HotelPlan.Domain.ValueObjects.HotelPlanDescription;
import com.webDevelopment.turistar.Hotel.HotelPlan.Domain.ValueObjects.HotelPlanPeopleNumber;
import com.webDevelopment.turistar.Hotel.HotelPlan.Domain.ValueObjects.HotelPlanPrice;
import com.webDevelopment.turistar.Hotel.HotelPlan.Domain.ValueObjects.HotelPlanQuantity;
import com.webDevelopment.turistar.Shared.Domain.HotelPlan.HotelPlanId;
import com.webDevelopment.turistar.Shared.Domain.HotelPlanBooking.HotelPlanBookingId;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryHotelPlanRepository implements HotelPlanRepository {

    private HotelPlan hotelPlan1 = new HotelPlan(new HotelPlanId("a0619482-a621-11eb-bcbc-0242ac130002"), new HotelPlanPrice(400000),new HotelPlanDescription("El mejor toursito"),new HotelPlanPeopleNumber(2),new HotelPlanBookingId("a0619482-a621-11eb-bcbc-0242ac130002"),new HotelPlanQuantity(10));
    private HotelPlan hotelPlan2 = new HotelPlan(new HotelPlanId("a06197e8-a621-11eb-bcbc-0242ac130002"), new HotelPlanPrice(200000),new HotelPlanDescription("El peor tour de colombia"),new HotelPlanPeopleNumber(3),new HotelPlanBookingId("a0619482-a621-11eb-bcbc-0242ac130002"),new HotelPlanQuantity(10));
    private HotelPlan hotelPlan3 = new HotelPlan(new HotelPlanId("a06198e2-a621-11eb-bcbc-0242ac130002"), new HotelPlanPrice(60000),new HotelPlanDescription("El mas o menos tour de colombia"),new HotelPlanPeopleNumber(4),new HotelPlanBookingId("a0619482-a621-11eb-bcbc-0242ac130002"),new HotelPlanQuantity(10));
    private List<HotelPlan> hotelPlans = new ArrayList<>(){{
        add(hotelPlan1);
        add(hotelPlan2);
        add(hotelPlan3);
    }};

    @Override
    public void update(String hotelPlanId, HotelPlan hotelPlan) {
        Optional<HotelPlan> hotelPlanToupdate = find(hotelPlanId);
        hotelPlanToupdate.ifPresent(value -> this.hotelPlans.remove(value));
        this.hotelPlans.add(hotelPlan);
    }

    @Override
    public Optional<HotelPlan> find(String hotelPlanId) {
        return hotelPlans.stream().filter(hotelPlan -> hotelPlan.equalsbyId(hotelPlanId)).findFirst();
    }

    @Override
    public void save(HotelPlan hotelPlan) {
        this.hotelPlans.add(hotelPlan);
    }

    @Override
    public Optional<List<HotelPlan>> all() {

        return Optional.ofNullable(this.hotelPlans);
    }
}
