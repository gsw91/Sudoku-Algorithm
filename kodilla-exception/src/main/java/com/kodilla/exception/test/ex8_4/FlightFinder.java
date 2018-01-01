package com.kodilla.exception.test.ex8_4;

import java.util.Map;

public class FlightFinder {
    public void findFlight (Flight flight) throws RouteNotFoundException {
        FlightData flightData = new FlightData();
        Map<String, Boolean> destinationFromBalice = flightData.Airports();

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
