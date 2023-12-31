package com.example.airline_api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "flights")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;
    @Column
    private String destination;
    @Column
    private int capacity;
    @Column
    private String departureDate;
    @Column(name = "departure_time")
    private String departureTime;

    @ManyToMany
    @JoinTable(
                name = "flights_passengers",
                joinColumns = {@JoinColumn(name = "flight_id")},
                inverseJoinColumns = {@JoinColumn(name = "passenger_id")}
    )

    @JsonIgnoreProperties({"flights"})
    private List<Passenger> passengers;

    public Flight(String destination, int capacity, String departureDate, String departureTime) {
        this.destination = destination;
        this.capacity = capacity;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.passengers = new ArrayList<>();
    }

    public Flight() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public void setPassenger(Passenger passenger) {

    }

    public List<Passenger> getPassenger() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }
}
