package com.kodilla.testing.collection;

import java.util.ArrayList;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

//Happy Christmas
/*Happy New Year*/

public class CollectionTestSuite {

    private static int testCounter = 0;

    @BeforeClass
    public static void testInitialing() {
        System.out.println("Wykonanie dwóch testów: \n " +
                "Pierwszy - bada zachowanie metody przy pustej liście \n " +
                "Drugi - bada zachowanie metody przy normalnej liście");
    }

    @Before
    public void testStarting() {
        testCounter++;
        System.out.println("\n Rozpoczynanie testu: " + testCounter + "\n");
    }

    @After
    public void testEnding() {
        System.out.println("\n Zakończenie testu. \n");
    }

    @Test
    public void testOddNumbersExterminatorEmptyList() {
        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        //When
        ArrayList<Integer> numbers = new ArrayList();
        numbers.isEmpty();
        oddNumbersExterminator.exterminate(numbers);
        //Then
        Assert.assertTrue(numbers.isEmpty());
        Assert.assertEquals(0, numbers.size());
    }

    @Test
    public void testOddNumbersExterminatorNormalList() {
        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        ArrayList<Integer> numbers = new ArrayList();
        numbers.add(0, 10);
        numbers.add(1, 3);
        numbers.add(2, 6);
        numbers.add(3, 1);
        numbers.add(4, 8);
        numbers.add(5, 0);
        numbers.add(6, 923);
        numbers.add(7, 1010);

        //When
        oddNumbersExterminator.exterminate(numbers);
        ArrayList<Integer> input = new ArrayList();
        ArrayList<Integer> output = new ArrayList();
        input.add(10);
        input.add(6);
        input.add(8);
        input.add(0);
        input.add(1010);

        //Then
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) % 2 == 0) {
                output.add(numbers.get(i));
            }
        }
        Assert.assertEquals((input.size()), output.size());

        for (int n = 0; n < input.size(); n++) {
            Assert.assertEquals(input.get(n), output.get(n));
        }
    }
}
