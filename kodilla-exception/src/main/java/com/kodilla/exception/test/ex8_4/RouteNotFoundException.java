package com.kodilla.exception.test;

public class RouteNotFoundException extends Exception {
    public void noAirport(){
        System.out.println("Brak połączenia z lotniskiem!");
    }
}
