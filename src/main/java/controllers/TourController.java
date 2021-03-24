package controllers;

import models.Tour;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/tour")
public class TourController {
     @PostMapping(value = "/",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Tour>  createTour(@RequestBody Tour tour){
        //TODO: Lógica de crear tour
        return null;
    }

    @PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateTour(@RequestBody Tour tour){
         //TODO:
         return  null;
    }

    @GetMapping(value = "/{tourId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Tour> getTourById(@PathVariable("tourId") int tourId ){
         //TODO: Lógica para obtner el tour por ID
        return null;
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<List<Tour>> getAllTours(){
         //TODO: Lógica para obtener todos los toures
         return  null;
    }
    @DeleteMapping(value = "/{tourId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteTour(@PathVariable("tourId") int tourId){
         //TODO: Lógica de eliminar un tour por ID
        return  null;
    }
}
