package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public final class FlightData {
    public Map<String, Boolean> Airports (){
        Map<String, Boolean> destinationFromBalice = new HashMap<>();
        destinationFromBalice.put("Berlin Airport", true);
        destinationFromBalice.put("Chopin Airport", true);
        return destinationFromBalice;
    }
}
