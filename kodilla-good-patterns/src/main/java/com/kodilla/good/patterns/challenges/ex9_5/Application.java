package com.kodilla.good.patterns.challenges.ex9_5;


import com.kodilla.good.patterns.challenges.ex9_5.AirportsList.*;


public class Application {

    public static void main (String[] args) {

        AirportsList airportsList = new AirportsList();
        airportsList.showAriportsList();

        FindFlight findFlight = new FindFlight();
        findFlight.FindFlightFrom("Warsaw");
        findFlight.FindFlightTo("Cracow");
        findFlight.FindLayover("Wroclaw");

    }


}
