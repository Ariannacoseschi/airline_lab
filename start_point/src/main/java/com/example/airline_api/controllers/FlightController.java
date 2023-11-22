package com.example.airline_api.controllers;

import com.example.airline_api.models.Flight;
import com.example.airline_api.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("flights")
public class FlightController {

    @Autowired
    FlightService flightService;

    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlights(
            @RequestParam(required = false, name = "flightPerPassenger") Integer flightPerPassenger
    ){
        if(flightPerPassenger != null){
            return new ResponseEntity<>(flightService.findAllFlightsPerPassenger(flightPerPassenger), HttpStatus.OK);
        }
        return new ResponseEntity<>(flightService.findAllFlights(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Flight>>getFlightById(@PathVariable Long id) {
        return new ResponseEntity(flightService.findFlight(id), HttpStatus.OK);
    }

}
