package com.kodilla.good.patterns.challenges.ex9_5.BasicClasses;

import java.time.LocalTime;

public class Flight {

    private  String departureAirport;
    private  String departureCity;
    private  String layover;
    private  String arrivalAirport;
    private  String arrivalCity;
    private  LocalTime departureHour;
    private  LocalTime arrivalHour;

    public Flight(String departureAirport, String departureCity, String layover, String arrivalAirport, String arrivalCity, LocalTime departureHour, LocalTime arrivalHour) {
        this.departureAirport = departureAirport;
        this.departureCity = departureCity;
        this.layover = layover;
        this.arrivalAirport = arrivalAirport;
        this.arrivalCity = arrivalCity;
        this.departureHour = departureHour;
        this.arrivalHour = arrivalHour;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public String getLayoverCity() {
        return layover;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public LocalTime getDepartureHour() {
        return departureHour;
    }

    public LocalTime getArrivalHour() {
        return arrivalHour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flight)) return false;

        Flight flight = (Flight) o;

        if (!getDepartureAirport().equals(flight.getDepartureAirport())) return false;
        if (!getDepartureCity().equals(flight.getDepartureCity())) return false;
        if (!getLayoverCity().equals(flight.getLayoverCity())) return false;
        if (!getArrivalAirport().equals(flight.getArrivalAirport())) return false;
        if (!getArrivalCity().equals(flight.getArrivalCity())) return false;
        if (!getDepartureHour().equals(flight.getDepartureHour())) return false;
        return getArrivalHour().equals(flight.getArrivalHour());
    }

    @Override
    public int hashCode() {
        int result = getDepartureAirport().hashCode();
        result = 31 * result + getDepartureCity().hashCode();
        result = 31 * result + getLayoverCity().hashCode();
        result = 31 * result + getArrivalAirport().hashCode();
        result = 31 * result + getArrivalCity().hashCode();
        result = 31 * result + getDepartureHour().hashCode();
        result = 31 * result + getArrivalHour().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Flight: " +
                "Departure Airport - '" + departureAirport + '\'' +
                ", Departure City - '" + departureCity + '\'' +
                ", Layover - '" + layover + '\'' +
                ", Arrival Airport - '" + arrivalAirport + '\'' +
                ", Arrival City - '" + arrivalCity + '\'' +
                ", Departure Hour " + departureHour +
                ", Arrival Hour " + arrivalHour +
                ' ';
    }


}
