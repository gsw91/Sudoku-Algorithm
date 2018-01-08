package com.kodilla.good.patterns.challenges.ex9_5.AirportsList;


import com.kodilla.good.patterns.challenges.ex9_5.BasicClasses.Flight;

import java.util.List;


public class FindFlight {

    private AirportsList airportsList = new AirportsList();
    private List<Flight> flights = airportsList.airportsList();

    public void FindFlightFrom(String departureCity) {

        System.out.println("Finding flights from: " + departureCity);

        flights.stream()
                .filter(flight -> flight.getDepartureCity().equals(departureCity))
                .forEach(System.out::println);

        long quantity = flights.stream()
                .filter(flight -> flight.getDepartureCity().equals(departureCity))
                .count();

        System.out.println("We have: " + quantity + " flight(s) from: " + departureCity);

    }

    public void FindFlightTo(String arrivalCity) {

        System.out.println("Finding flights to: " + arrivalCity);

        flights.stream()
                .filter(flight -> flight.getArrivalCity().equals(arrivalCity))
                .forEach(System.out::println);

        long quantity = flights.stream()
                .filter(flight -> flight.getArrivalCity().equals(arrivalCity))
                .count();

        System.out.println("We have: " + quantity + " flight(s) to: " + arrivalCity);

    }

    public void FindLayover(String layoverCity) {

        System.out.println("Finding layovers in: " + layoverCity);

        flights.stream()
                .filter(flight -> flight.getLayoverCity().equals(layoverCity))
                .forEach(System.out::println);

        long quantity = flights.stream()
                .filter(flight -> flight.getLayoverCity().equals(layoverCity))
                .count();

        System.out.println("We have: " + quantity + " layover(s) io: " + layoverCity);

    }


}