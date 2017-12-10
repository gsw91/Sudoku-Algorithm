package com.kodilla.testing.collection;

import java.util.ArrayList;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

//Happy Christmas
/*Happy New Year*/

public class CollectionTestSuite {

    private static int testCounter = 0;

    @BeforeClass
    public static void testInitializing() {
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
        ArrayList<Integer> input = new ArrayList();
        input.isEmpty();
        oddNumbersExterminator.exterminate(input);
        //Then
        Assert.assertTrue(input.isEmpty());
        Assert.assertEquals(0, input.size());
    }

    @Test
    public void testOddNumbersExterminatorNormalList() {
        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        ArrayList<Integer> input = new ArrayList<>();
        ArrayList<Integer> expectedResult = new ArrayList<>();
        ArrayList<Integer> actualResult  = new ArrayList<>();
        input.add(0, 10);
        input.add(1, 3);
        input.add(2, 6);
        input.add(3, 1);
        input.add(4, 8);
        input.add(5, 0);
        input.add(6, 923);
        input.add(7, 1010);

        expectedResult.add(0,10);
        expectedResult.add(1,6);
        expectedResult.add(2,8);
        expectedResult.add(3,0);
        expectedResult.add(4,1010);

        //When
        actualResult = oddNumbersExterminator.exterminate(input);

        //Then
        Assert.assertEquals(actualResult.size(), expectedResult.size());

        Assert.assertEquals(expectedResult.get(0), actualResult.get(0));
        Assert.assertEquals(expectedResult.get(1), actualResult.get(1));
        Assert.assertEquals(expectedResult.get(2), actualResult.get(2));
        Assert.assertEquals(expectedResult.get(3), actualResult.get(3));
        Assert.assertEquals(expectedResult.get(4), actualResult.get(4));
        Assert.assertEquals(expectedResult, actualResult);
    }
}
