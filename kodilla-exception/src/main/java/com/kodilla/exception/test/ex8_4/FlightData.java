package com.kodilla.exception.test.ex8_4;

import java.util.HashMap;
import java.util.Map;

public final class FlightData {
    public Map<String, Boolean> Airports (){
        Map<String, Boolean> destinationFromBalice = new HashMap<>();
        destinationFromBalice.put("Berlin Airport", false);
        destinationFromBalice.put("Chopin Airport", true);
        return destinationFromBalice;
    }
}
