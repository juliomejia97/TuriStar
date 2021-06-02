package com.webDevelopment.turistar.Administrator.TourSpot.Domain;

import com.webDevelopment.turistar.Administrator.TourSpot.Domain.ValueObjects.*;
import com.webDevelopment.turistar.Shared.Domain.Aggregate.AggregateRoot;
import com.webDevelopment.turistar.Shared.Domain.City.CityId;
import com.webDevelopment.turistar.Shared.Domain.Tour.TourId;
import com.webDevelopment.turistar.Shared.Domain.TourSpot.TourSpotCreatedEventDomain;
import com.webDevelopment.turistar.Shared.Domain.TourSpot.TourSpotId;
import com.webDevelopment.turistar.Shared.Domain.TourSpot.TourSpotUpdatedDomainEvent;

import java.util.*;

public class TourSpot extends AggregateRoot {

    private TourSpotId tourSpotId;
    private CityId cityId;
    private TourSpotName tourSpotName;
    private TourSpotLatitude latitude;
    private TourSpotLongitude longitude;
    private TourSpotDescription description;
    private TourSpotActive tourSpotActive;
    private Optional<List<TourId>> toursId;
    private Optional<List<TourSpotPhoto>> photos;

    private TourSpot(TourSpotId tourSpotId, CityId cityId,TourSpotName tourSpotName,
                     TourSpotLatitude latitude, TourSpotLongitude longitude,
                     TourSpotDescription description, List<TourId> tourIds, List<TourSpotPhoto> photos) {
        this.tourSpotId = tourSpotId;
        this.cityId = cityId;
        this.tourSpotName = tourSpotName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.description = description;
        this.tourSpotActive = new TourSpotActive(true);
        this.toursId = Optional.ofNullable(tourIds);
        this.photos = Optional.ofNullable(photos);
    }

    public static TourSpot create(TourSpotId tourSpotId, CityId cityId,TourSpotName tourSpotName,
                                  TourSpotLatitude latitude, TourSpotLongitude longitude,
                                  TourSpotDescription description, List<TourSpotPhoto> photos){
        TourSpotActive active = new TourSpotActive(true);
        TourSpot newTourSpot = new TourSpot(tourSpotId,cityId,tourSpotName,latitude,longitude,description,
                null, photos);
        newTourSpot.record(new TourSpotCreatedEventDomain(cityId.value(), tourSpotId.value(), tourSpotName.value(), latitude.value(), longitude.value(),
                description.value(),newTourSpot.dataTourSpotPhotos(),active.value()) );
        return newTourSpot;
    }
    private TourSpot() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TourSpot tourSpot = (TourSpot) o;
        return Objects.equals(tourSpotId, tourSpot.tourSpotId) && Objects.equals(cityId, tourSpot.cityId) && Objects.equals(tourSpotName, tourSpot.tourSpotName) && Objects.equals(latitude, tourSpot.latitude) && Objects.equals(longitude, tourSpot.longitude) && Objects.equals(description, tourSpot.description) && Objects.equals(tourSpotActive, tourSpot.tourSpotActive) && Objects.equals(toursId, tourSpot.toursId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tourSpotId, cityId, tourSpotName, latitude, longitude, description, tourSpotActive, toursId);
    }

    public HashMap<String, Object> data()
    {
        HashMap<String, Object> data = new HashMap<>() {{
            put("tourSpotId", tourSpotId.value());
            put("cityId",cityId.value());
            put("name", tourSpotName.value());
            put("latitude",String.valueOf(latitude.value()));
            put("longitude",String.valueOf(longitude.value()));
            put("description",description.value());
            put("active",tourSpotActive.value().toString());
            put("toursId", dataToursId());
            put("photos",dataTourSpotPhotos());
        }};
        return data;
    }

    private ArrayList<String> dataToursId(){
        ArrayList<String> response = new ArrayList<>();
        if(this.toursId.isPresent()) {
            List<TourId> photos  = this.toursId.get();
            photos.stream().forEach(tourId -> response.add(tourId.value()));
        }
        return response;
    }
    private ArrayList<String> dataTourSpotPhotos(){
        ArrayList<String> response = new ArrayList<>();
        if(this.photos.isPresent()) {
            List<TourSpotPhoto> photos  = this.photos.get();
            photos.stream().forEach(tourSpotPhoto -> response.add(tourSpotPhoto.value()));
        }
        return response;
    }
    public void updateTour(String tourName, Double latitude, Double longitude, String description, List<TourSpotPhoto> photos) {
        this.analyseTourSpotName(tourName,photos);
        this.tourSpotName = new TourSpotName(tourName);
        this.latitude = new TourSpotLatitude(latitude);
        this.longitude = new TourSpotLongitude(longitude);
        this.description = new TourSpotDescription(description);
        //TODO: Modificar evento para almacenar el array de String para fotos para Tour y enviarselo a todos los que me tienen
        //this.record(new TourSpotUpdatedDomainEvent(this.tourId.value(), this.tourSpotName.value(), this.latitude.value(), this.longitude.value(), this.description.value(), true));
        this.record(new TourSpotUpdatedDomainEvent(this.cityId.value(),this.tourSpotId.value(),this.tourSpotName.value(), this.latitude.value(),
                this.longitude.value(), this.description.value(), this.dataTourSpotPhotos(),false) );
    }

    private void analyseTourSpotName(String tourName, List<TourSpotPhoto> tourSpotPhotos){
        if(tourName.equalsIgnoreCase(this.tourSpotName.value())){
            //TODO: Hacer lo mismo con Toures
            List<TourSpotPhoto> photos = this.photos.get();
            tourSpotPhotos.stream().forEach(tourSpotPhoto -> photos.add(tourSpotPhoto));
            this.photos = Optional.of(photos);
        }else{
            this.photos = Optional.of(tourSpotPhotos);
        }
    }
    public Boolean equalsById(String idTourSpot){
        return this.tourSpotId.equals(new TourSpotId(idTourSpot));
    }

}
