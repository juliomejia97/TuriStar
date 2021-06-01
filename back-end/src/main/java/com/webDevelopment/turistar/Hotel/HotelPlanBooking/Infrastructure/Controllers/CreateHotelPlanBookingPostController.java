package com.webDevelopment.turistar.Hotel.HotelPlanBooking.Infrastructure.Controllers;

import com.webDevelopment.turistar.Hotel.HotelPlanBooking.Application.Create.HotelPlanBookingCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.HashMap;

@RestController
public class CreateHotelPlanBookingPostController {

    @Autowired
    private HotelPlanBookingCreator creator;

    @PostMapping(value = "/HotelPlanBooking/",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity execute(@RequestBody Request request) {
        creator.execute(request.getId(),request.getUserId(), request.getHotelPlanBookingInitDate(), request.getHotelPlanBookingEndDate());
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<HashMap> TourException(RuntimeException exception){
        HashMap<String,String> response = new HashMap<>(){{
            put("error",exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    static class Request {
        String id;
        String userId;
        private LocalDate hotelPlanBookingInitDate;
        private LocalDate hotelPlanBookingEndDate;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public LocalDate getHotelPlanBookingInitDate() {
            return hotelPlanBookingInitDate;
        }

        public void setHotelPlanBookingInitDate(LocalDate hotelPlanBookingInitDate) {
            this.hotelPlanBookingInitDate = hotelPlanBookingInitDate;
        }

        public LocalDate getHotelPlanBookingEndDate() {
            return hotelPlanBookingEndDate;
        }

        public void setHotelPlanBookingEndDate(LocalDate hotelPlanBookingEndDate) {
            this.hotelPlanBookingEndDate = hotelPlanBookingEndDate;
        }
    }
}
