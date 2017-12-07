package com.kodilla.testing.collection;

import java.util.ArrayList;
import java.util.Random;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

//Happy Christmas


public class CollectionTestSuite {

    @BeforeClass
    public static void testInitialing() {
        System.out.println("Wykonanie dwóch testów: \n " +
                "Pierwszy - bada zachowanie metody przy pustej liście \n " +
                "Drugi - bada zachowanie metody przy normalnej liście");
    }

    @Before
    public void testStarting() {
        System.out.println("\n Rozpoczynanie testu: \n");
    }

    @Test
    public void testOddNumbersExterminatorEmptyList() {
        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        //When
        ArrayList<Integer> numbers = new ArrayList();
        int test = oddNumbersExterminator.exterminate(numbers).intValue();
        //Then
        Assert.assertTrue(numbers.isEmpty());
    }

    @Test
    public void testOddNumbersExterminatorNormalList() {
        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        ArrayList<Integer> numbers = new ArrayList();
        Random generator = new Random();

        int test;
        for(test = 0; test < 10; ++test) {
            numbers.add(generator.nextInt(10));
        }
        //When
        test = oddNumbersExterminator.exterminate(numbers).intValue();
        ArrayList<Integer> check = new ArrayList();
        //Then
        for(int i = 0; i < numbers.size(); ++i) {
            if (((Integer)numbers.get(i)).intValue() % 2 == 0) {
                check.add(numbers.get(i));
            }
        }
        Assert.assertEquals((long)test, (long)check.size());
    }

    @After
    public void testEnding() {
        System.out.println("\n Zakończenie testu: \n");
    }
}
