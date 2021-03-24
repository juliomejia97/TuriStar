package controllers;

import models.TouristicSpot;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/touristicSpot")
public class TouristicSpotController {

    @PostMapping(value = "/",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TouristicSpot> createTouristicSpot(@RequestBody TouristicSpot touristiSpot){
        //TODO: Lógica de crear tour
        return null;
    }

    @PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateTouristicSpot(@RequestBody TouristicSpot touristiSpot){
        //TODO:
        return  null;
    }

    @GetMapping(value = "/{touristicSpotId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TouristicSpot> getTouristicSpotById(@PathVariable("touristicSpotId") int touristicSpotId){
        //TODO: Lógica para obtner el tour por ID
        return null;
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<List<TouristicSpot>> getAllTouristicSpots(){
        //TODO: Lógica para obtener todos los toures
        return  null;
    }
    @DeleteMapping(value = "/{touristicSpotId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteTouristicSpot(@PathVariable("touristicSpotId") int touristicSpotId){
        //TODO: Lógica de eliminar un tour por ID
        return  null;
    }
}
