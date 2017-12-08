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
        output.add(10);
        output.add(6);
        output.add(8);
        output.add(0);
        output.add(1010);

        //Then
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) % 2 == 0) {
                input.add(numbers.get(i));
            }
        }
        Assert.assertEquals((output.size()), input.size());

        for (int n = 0; n < output.size(); n++) {
            Assert.assertEquals(output.get(n), input.get(n));
        }
    }
}
