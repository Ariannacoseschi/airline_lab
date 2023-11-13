package com.example.airline_api.services;

import com.example.airline_api.models.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
    public class PassengerService {

        @Autowired
        PassengerRepository passengerRepository;

        @Autowired
        FlightService flightService;

        public List<Passenger> getAllPassengers() {
            return passengerRepository.findAll();
        }

        public Passenger getPassengerById(Long id) {
            return passengerRepository.findById(id).get();
        }

        public Passenger addNewPassenger(Passenger passenger) {
            passengerRepository.add(passenger);
            return passenger;
        }


    }
