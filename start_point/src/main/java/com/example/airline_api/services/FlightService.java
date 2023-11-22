package com.example.airline_api.services;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerService passengerService;

    //finding all the flights beloging to a passenger
    public List<Flight> findAllFlightsPerPassenger(int flights) {
        return flightRepository.findAllFligthsPerPassenger(flights);
    }

    public List<Flight> findAllFlights() {
        return flightRepository.findAll();
    }

    public Flight findFlight(Long id) {
        return flightRepository.findById(id).get();
    }

    // saving and returning flight Object
    public Flight saveFlight(Flight flight) {
        flightRepository.save(flight);
        return flight;
    }

    @Transactional
    public Flight addPassengerToFlight(long flightId, long passengerId){
        Flight flight = flightRepository.flightById(flightId).get((int) flightId); //i wrote the code the way i thought it is supposed to go but kept getting error and it re-correcting to get((int) and im unsure as to why yet
        Passenger passenger = new Passenger();
        List<Passenger> passengers = flight.getPassenger();
        passengers.add(passenger);
        flight.setPassenger(passenger);
        flightRepository.save(flight);
        return flight;
    }

    public void deleteFlight(long id) { flightRepository.deleteById(id);}



}

