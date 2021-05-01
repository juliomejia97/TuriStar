package com.webDevelopment.turistar.Tour.TourBooking.Infrastructure.Controllers;

import com.webDevelopment.turistar.Tour.TourBooking.Application.Create.TourBookingCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;

public class CreateTourBookingPostController {

    @Autowired
    private TourBookingCreator creator;

    @PostMapping(value = "/create",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity execute(@RequestBody Request request) {
        creator.execute(request.getId(), request.getTourBookingInitDate(), request.getTourBookingEndDate());
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    static class Request {
        private String id;
        private LocalDate tourBookingInitDate;
        private LocalDate tourBookingEndDate;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public LocalDate getTourBookingInitDate() {
            return tourBookingInitDate;
        }

        public void setTourBookingInitDate(LocalDate tourBookingInitDate) {
            this.tourBookingInitDate = tourBookingInitDate;
        }

        public LocalDate getTourBookingEndDate() {
            return tourBookingEndDate;
        }

        public void setGetTourBookingEndDate(LocalDate tourBookingEndDate) {
            this.tourBookingEndDate = tourBookingEndDate;
        }
    }
}
