package com.webDevelopment.turistar.Tour.Tour.Infrastructure.Controllers;

import com.webDevelopment.turistar.Shared.Domain.UUIDNotValid;
import com.webDevelopment.turistar.Tour.Tour.Application.Create.TourCreator;
import com.webDevelopment.turistar.Tour.Tour.Domain.Exceptions.LengthNotValid;
import com.webDevelopment.turistar.Tour.Tour.Domain.Exceptions.NegativeNumber;
import com.webDevelopment.turistar.Tour.Tour.Domain.Exceptions.TourDescriptionError;
import com.webDevelopment.turistar.Tour.Tour.Domain.Exceptions.TourDuplicated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value="/Tour")
public class CreateTourPostController {

    @Autowired
    private TourCreator tourCreator;

    @PostMapping(value = "/create/")
    public ResponseEntity<HashMap> execute(@RequestBody CreateTourPostController.Request request){
        tourCreator.execute(request.id, request.getName(),request.getDescription(),
                request.getBookings(),request.getPrice(),request.getTourSpotsId());
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @ExceptionHandler({TourDuplicated.class, UUIDNotValid.class, LengthNotValid.class, TourDescriptionError.class,
            NegativeNumber.class})
    public  ResponseEntity<HashMap> informationNotvalid(Exception exception){
        HashMap<String,String> response = new HashMap<>(){{
            put("error",exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
    private static class Request{
        private String id;
        private String name;
        private String description;
        private Integer bookings;
        private Double price;
        private List<String> tourSpotsId;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Integer getBookings() {
            return bookings;
        }

        public void setBookings(Integer bookings) {
            this.bookings = bookings;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }

        public List<String> getTourSpotsId() {
            return tourSpotsId;
        }

        public void setTourSpotsId(List<String> tourSpotsId) {
            this.tourSpotsId = tourSpotsId;
        }
    }
}
