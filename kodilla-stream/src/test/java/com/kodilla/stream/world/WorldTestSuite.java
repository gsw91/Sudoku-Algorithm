package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class WorldTestSuite {

    @Test
    public void testGetPeopleQuantity(){
        //Given
        World world = new World();

        ArrayList<Country> europePopulation = new ArrayList<Country>();
        europePopulation.add(new Country("Polska", BigInteger.valueOf(546456235L)));
        europePopulation.add(new Country("Czechy", BigInteger.valueOf(24545654L)));
        europePopulation.add(new Country("Słowacja", BigInteger.valueOf(34567354L)));
        europePopulation.add(new Country("Ukraina", BigInteger.valueOf(745667658574L)));
        europePopulation.add(new Country("Białoruś", BigInteger.valueOf(3456787565L)));
        Continent europe = new Continent("Europa", europePopulation);
        world.addContinent(europe);

        ArrayList<Country> africaPopulation = new ArrayList<>();
        africaPopulation.add(new Country("Czad", BigInteger.valueOf(12323434L)));
        africaPopulation.add(new Country("Kongo", BigInteger.valueOf(23434545L)));
        africaPopulation.add(new Country("Niger", BigInteger.valueOf(23424567L)));
        africaPopulation.add(new Country("Etiopia", BigInteger.valueOf(34512311L)));
        africaPopulation.add(new Country("Sudan", BigInteger.valueOf(10000002L)));
        Continent africa = new Continent("Afryka", africaPopulation);
        world.addContinent(africa);
        //When
        BigInteger actualAll = world.getPeopleQuantity();
        BigInteger actualEurope = world.getContinentPopulation(europe);
        BigInteger actualAfrica = world.getContinentPopulation(africa);
        BigInteger expectedEurope = BigInteger.valueOf(749730015382L);
        BigInteger expectedAfrica = BigInteger.valueOf(103694859L);
        BigInteger expectedWorld = BigInteger.valueOf(749833710241L);
        int actualCountriesQuantity = world.getAllCountries().size();
        //Then
        Assert.assertEquals(expectedEurope, actualEurope);
        Assert.assertEquals(expectedAfrica, actualAfrica);
        Assert.assertEquals(expectedWorld, actualAll);
        Assert.assertEquals(2, world.getContinentsSize());
        Assert.assertEquals(10, actualCountriesQuantity);
    }
}
