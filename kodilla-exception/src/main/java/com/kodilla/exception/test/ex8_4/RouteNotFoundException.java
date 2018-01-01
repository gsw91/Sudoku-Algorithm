package com.kodilla.exception.test.ex8_4;

public class RouteNotFoundException extends Exception {
    public void noAirport(){
        System.out.println("Nie latamy do tego lotniska!");
    }
}
