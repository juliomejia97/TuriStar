package com.webDevelopment.turistar.Tour.TourBooking.Infrastructure.Controllers;

import com.webDevelopment.turistar.Tour.TourBooking.Application.Create.TourBookingCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class CreateTourBookingPostController {

    @Autowired
    private TourBookingCreator creator;

    @PostMapping(value = "/TourBooking/",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity execute(@RequestBody Request request) {
        creator.execute(request.getTourBookingId(), request.getTourBookingInitDate(), request.getTourBookingEndDate(), request.getTourId(), request.getUserId());
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    static class Request {
        private String tourBookingId;
        private LocalDate tourBookingInitDate;
        private LocalDate tourBookingEndDate;
        private String tourId;
        private String userId;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public void setTourBookingEndDate(LocalDate tourBookingEndDate) {
            this.tourBookingEndDate = tourBookingEndDate;
        }

        public String getTourId() {
            return tourId;
        }

        public void setTourId(String tourId) {
            this.tourId = tourId;
        }

        public String getTourBookingId() {
            return tourBookingId;
        }

        public void setTourBookingId(String tourBookingId) {
            this.tourBookingId = tourBookingId;
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

    }
}
