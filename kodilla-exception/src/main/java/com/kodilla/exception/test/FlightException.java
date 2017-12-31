package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightException {
    public void findFlight (Flight flight) throws RouteNotFoundException {
        Map<String, Boolean> destinationFromBalice = new HashMap<>();
        destinationFromBalice.put("Berlin Airport", true);
        destinationFromBalice.put("Chopin Airport", true);

        if (destinationFromBalice.containsKey(flight.getArrivalAirport())){
            if(destinationFromBalice.putIfAbsent(flight.getArrivalAirport(), true)) {
                System.out.println(flight.toString());
            } else{
                System.out.println("Brak lotu do: " + flight.getArrivalAirport());
            }
        } else {
            throw new RouteNotFoundException();
        }
    }

    public static void main (String[] args){
        FlightException flightException = new FlightException();
        Flight flight = new Flight("Balice Airport","Balicegit  Airport");

        try{
            flightException.findFlight(flight);
        } catch (RouteNotFoundException e) {
            System.out.println("Ops... something gone wrong! Error: " + e);
            RouteNotFoundException routeNotFoundException = new RouteNotFoundException();
            routeNotFoundException.noAirport();
        }
    }
}
