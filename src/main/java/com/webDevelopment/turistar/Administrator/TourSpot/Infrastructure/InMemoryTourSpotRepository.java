package com.webDevelopment.turistar.Administrator.TourSpot.Infrastructure;

import com.webDevelopment.turistar.Administrator.TourSpot.Domain.Ports.TourSpotRepository;
import com.webDevelopment.turistar.Administrator.TourSpot.Domain.TourSpot;
import com.webDevelopment.turistar.Administrator.TourSpot.Domain.ValueObjects.TourSpotDescription;
import com.webDevelopment.turistar.Administrator.TourSpot.Domain.ValueObjects.TourSpotLatitude;
import com.webDevelopment.turistar.Administrator.TourSpot.Domain.ValueObjects.TourSpotLongitude;
import com.webDevelopment.turistar.Administrator.TourSpot.Domain.ValueObjects.TourSpotName;
import com.webDevelopment.turistar.Shared.Domain.City.CityId;
import com.webDevelopment.turistar.Shared.Domain.TourSpot.TourSpotId;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryTourSpotRepository implements TourSpotRepository {
    private TourSpot t1 = new TourSpot(new TourSpotId("28967a36-ac74-11eb-8529-0242ac130003"),
            new CityId("a0619482-a621-11eb-bcbc-0242ac130002"),
            new TourSpotName("Monserrate"), new TourSpotLatitude(4.6056728), new TourSpotLongitude(-74.0555255),
            new TourSpotDescription("Una bella vista de Bogotá, ideal para ir en la noche"));
    private TourSpot t2 = new TourSpot(new TourSpotId("28967cb6-ac74-11eb-8529-0242ac130003"),
            new CityId("a0619482-a621-11eb-bcbc-0242ac130002"),
            new TourSpotName("Chorro de Quevedo"), new TourSpotLatitude(4.5971128), new TourSpotLongitude(-74.06994689999999),
            new TourSpotDescription("Un lindo sitio para tomar canelazo"));
    private TourSpot t3 = new TourSpot(new TourSpotId("28967fe0-ac74-11eb-8529-0242ac130003"),
            new CityId("a0619482-a621-11eb-bcbc-0242ac130002"),
            new TourSpotName("Museo del Oro"), new TourSpotLatitude(4.6016886), new TourSpotLongitude(-74.07188529999999),
            new TourSpotDescription("Ideal para enteder la historia de Colombia"));
    private List<TourSpot> tourSpots = new ArrayList<>(){{
        add(t1);
        add(t2);
        add(t3);
    }};
    @Override
    public void update(TourSpot tourSpot) {
        this.tourSpots.remove(tourSpot);
        this.tourSpots.add(tourSpot);
    }

    @Override
    public Optional<TourSpot> find(String tourId) {
        return tourSpots.stream().filter(tourSpot -> tourSpot.equalsById(tourId)).findFirst();
    }

    @Override
    public void save(TourSpot tourSpot) {
        this.tourSpots.add(tourSpot);
    }

    @Override
    public Optional<List<TourSpot>> all() {
        return Optional.ofNullable(this.tourSpots);
    }


}
