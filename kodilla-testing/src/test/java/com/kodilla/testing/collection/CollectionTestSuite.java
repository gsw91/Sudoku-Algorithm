package com.kodilla.testing.collection;

import java.util.ArrayList;
import java.util.Random;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CollectionTestSuite {
    public CollectionTestSuite() {
    }

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
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        ArrayList<Integer> numbers = new ArrayList();
        int test = oddNumbersExterminator.exterminate(numbers).intValue();
        Assert.assertTrue(numbers.isEmpty());
    }

    @Test
    public void testOddNumbersExterminatorNormalList() {
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        ArrayList<Integer> numbers = new ArrayList();
        Random generator = new Random();

        int test;
        for(test = 0; test < 10; ++test) {
            numbers.add(generator.nextInt(10));
        }

        test = oddNumbersExterminator.exterminate(numbers).intValue();
        ArrayList<Integer> check = new ArrayList();

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
