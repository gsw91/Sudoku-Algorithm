package com.kodilla.stream.world;

import java.util.*;

public final class Continent {

    private final String name;
    private final ArrayList<Country> countriesList;

    public Continent(String name, ArrayList<Country> countriesList) {
        this.name = name;
        this.countriesList = countriesList;
    }

    public String getName() {
        return name;
    }

    public void addCountry(Country country) {
        countriesList.add(country);
    }

    public boolean removeCountry(Country country) {
        return countriesList.remove(country);
    }

    public List<Country> getCountriesList() {
        return countriesList;
    }
}
