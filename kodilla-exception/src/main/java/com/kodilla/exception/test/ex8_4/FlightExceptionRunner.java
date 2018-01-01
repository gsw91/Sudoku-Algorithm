package com.kodilla.exception.test.ex8_4;

public class FlightExceptionRunner {

    public static void main (String[] args) {
        FlightFinder flightException = new FlightFinder();
        Flight flight1 = new Flight("Balice Airport", "Chopin Airport");
        Flight flight2 = new Flight("Balice Airport", "Berlin Airport");
        Flight flight3 = new Flight("Balice Airport", "Error");

        try {
            flightException.findFlight(flight1);
            flightException.findFlight(flight2);
            flightException.findFlight(flight3);
        } catch (RouteNotFoundException e) {
            System.out.println("Ops... something gone wrong! Error: " + e);
            RouteNotFoundException routeNotFoundException = new RouteNotFoundException();
            routeNotFoundException.noAirport();
        }
    }
}
