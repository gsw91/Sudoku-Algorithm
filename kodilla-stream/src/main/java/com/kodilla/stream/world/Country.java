package com.kodilla.stream.world;

import java.math.BigInteger;

public final class Country {

    private final String name;
    private final BigInteger population;

    public Country(final String name, final BigInteger population) {
        this.name = name;
        this.population = population;
    }

    public String getCountryName(){
        return name;
    }

    public BigInteger getPeopleQuantity(){
        return population;
    }
}
