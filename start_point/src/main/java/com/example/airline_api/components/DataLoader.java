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


        @Override
        public void run(ApplicationArguments args) throws Exception {

            Flight flight1 = new Flight("JK", 2, "10-10-2023", "16:00PM");
            flightRepository.addNewFlight(flight1);

            Flight flight2 = new Flight("lIMA", 2, "10-10-2023", "16:00PM");
            flightRepository.addNewFlight(flight2);

            Passenger colin = new Passenger("Suana Cole"," suanacole@gmail.com");
            passengerRepository.addNewPassenger(colin);

            Passenger anna = new Passenger("Lein Cole", "leincole@gmail.com");
            passengerRepository.addNewPassenger(anna);
        }

    }






