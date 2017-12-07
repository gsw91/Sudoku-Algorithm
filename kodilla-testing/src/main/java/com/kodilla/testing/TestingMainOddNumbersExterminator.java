package com.kodilla.testing;

import com.kodilla.testing.collection.OddNumbersExterminator;
import java.util.ArrayList;
import java.util.Random;

class TestingMainOddNumbersExterminator {

    public static void main(String[] args) throws Exception {
        ArrayList <Integer> numbers = new ArrayList();
        Random generator = new Random();

        for(int i = 0; i < 2000; ++i) {
            numbers.add(generator.nextInt(100));
            System.out.println("Wygenerowana liczba " + i + " listy 1 to: " + numbers.get(i));
        }

        System.out.println("\n Szukanie liczb parzystych... \n");
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        oddNumbersExterminator.exterminate(numbers);
    }
}
