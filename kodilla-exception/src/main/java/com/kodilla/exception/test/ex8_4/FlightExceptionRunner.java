package com.kodilla.exception.test;

public class FlightExceptionRunner {

    public static void main (String[] args){
        FlightFinder flightFinder = new FlightFinder();
        Flight flight1 = new Flight("Balice Airport","Berlin  Airport");

        try{
            flightFinder.findFlight(flight1);
        } catch (RouteNotFoundException e) {
            System.out.println("Ops... something gone wrong! Error: " + e);
            RouteNotFoundException routeNotFoundException = new RouteNotFoundException();
            routeNotFoundException.noAirport();
        }
    }
}
