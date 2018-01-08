package com.kodilla.good.patterns.challenges.ex9_5.AirportsList;


import com.kodilla.good.patterns.challenges.ex9_5.BasicClasses.Flight;

import java.time.LocalTime;
import java.util.*;


public class AirportsList {

    List airportsList() {

        List<Flight> flightsList = new ArrayList<>();

        Flight flight1 = new Flight("Balice", "Cracow","No", "Chopin", "Warsaw", LocalTime.of(12,0), LocalTime.of(13, 5));
        Flight flight2 = new Flight("Balice", "Cracow","No", "Starachowice", "Wroclaw", LocalTime.of(16,0), LocalTime.of(16,45));
        Flight flight3 = new Flight("Chopin", "Warsaw", "Wroclaw","Balice", "Cracow", LocalTime.of(17,30), LocalTime.of(18,30));
        Flight flight4 = new Flight("Chopin", "Warsaw", "Wroclaw", "Starachowice", "Wroclaw", LocalTime.of(10,15), LocalTime.of(11,5));

        flightsList.add(flight1);
        flightsList.add(flight2);
        flightsList.add(flight3);
        flightsList.add(flight4);

        return flightsList;

    }

    public void showAriportsList() {

        List<Flight> showFlights = airportsList();

        System.out.println("All our flights: ");

        showFlights.forEach(System.out::println);

    }


}
