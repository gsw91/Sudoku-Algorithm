package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightFinder {
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
        FlightFinder flightException = new FlightFinder();
        Flight flight = new Flight("Balice Airport","Chopin  Airport");

        try{
            flightException.findFlight(flight);
        } catch (RouteNotFoundException e) {
            System.out.println("Ops... something gone wrong! Error: " + e);
            RouteNotFoundException routeNotFoundException = new RouteNotFoundException();
            routeNotFoundException.noAirport();
        }
    }
}
    //public void findFlight (Flight flight) throws RouteNotFoundException {
      //  FlightData flightData = new FlightData();
        //Map<String, Boolean> airports = flightData.Airports();

//        if (airports.containsKey(flight.getArrivalAirport())){
  //          if(airports.getOrDefault(flight.getArrivalAirport(), true)) {
    //            System.out.println(flight.toString());
      //      } else {
        //        System.out.println("Brak lotu do: " + flight.getArrivalAirport());
          //  }
//        } else {
  //          throw new RouteNotFoundException();
    //    }
      //  FlightFinder flightFinder = new FlightFinder();
        //Flight flight1 = new Flight("Balice Airport","Berlin  Airport");
    //}
//}
