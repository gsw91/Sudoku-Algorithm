package com.kodilla.stream.world;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

public final class World {
    private final List<Continent> continentsList = new ArrayList<>();

    public void addContinent(Continent continent) {
        continentsList.add(continent);
    }

    public boolean removeItem(Continent continent) {
        return continentsList.remove(continent);
    }

    public BigInteger getContinentPopulation(Continent continent) {
        return continent.getCountriesList().stream()
                .map(Country::getPeopleQuantity)
                .reduce(BigInteger.ZERO, (sum, current) -> sum = sum.add(current));
    }

    public int getContinentsSize(){
        return continentsList.size();
    }

    public List<String> getAllCountries(){
        return continentsList.stream()
                .flatMap(continent -> continent.getCountriesList().stream())
                .map(Country::getCountryName)
                .collect(Collectors.toList());
    }

    @Override
    public String toString(){
        return "World{" +
                "continentsList=" + continentsList +
                '}';
    }

    public BigInteger getPeopleQuantity() {
        return continentsList.stream()
                .flatMap(continent -> continent.getCountriesList().stream())
                .map(Country::getPeopleQuantity)
                .reduce(BigInteger.ZERO, (sum, current) -> sum = sum.add(current));
    }
}