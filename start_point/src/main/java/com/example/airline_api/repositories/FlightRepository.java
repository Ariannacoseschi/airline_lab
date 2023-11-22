package com.example.airline_api.repositories;

import com.example.airline_api.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    List<Flight> findAllFligthsPerPassenger(int flightPerPassenger);

    List<Flight> flightById(long flightId);

// save(),
}
