package com.example.airline_api.components;


import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;



    @Component
    public class DataLoader implements ApplicationRunner {
        @Autowired
        FlightRepository flightRepository;

        @Autowired
        PassengerRepository passengerRepository;

        public DataLoader() {
        }

        public DataLoader(PassengerRepository passengerRepository, FlightRepository flightRepository){
            this.passengerRepository = passengerRepository;
            this.flightRepository = flightRepository;
        }

       // running
        @Override
        public void run(ApplicationArguments args) throws Exception {
            //taking in destination, capacity, departureDate and departureTime

            Flight flight = new Flight("Lima", 2, "15-11-2023", "Morning");
            flightRepository.save(flight);

            Passenger passenger = new Passenger("Sarah", "Sarahjames@google.com");
            passengerRepository.save(passenger);

            Passenger passenger1 = new Passenger("Betty", "BettyBoop@bettyworld.com");
            passengerRepository.save(passenger1);

            Passenger passenger2 = new Passenger("Taylor", "Taylor@swifties.com");
            passengerRepository.save(passenger2);

        }


    }






