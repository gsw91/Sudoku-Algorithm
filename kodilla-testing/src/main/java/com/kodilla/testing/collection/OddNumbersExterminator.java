package com.kodilla.testing.collection;

import java.util.ArrayList;
import java.util.Iterator;

public class OddNumbersExterminator {

    public OddNumbersExterminator() {
    }

    public Integer exterminate(ArrayList<Integer> numbers) {
        ArrayList<Integer> check = new ArrayList();

        Integer checkTest;
        for(int n = 0; n < numbers.size(); ++n) {
            checkTest = ((Integer)numbers.get(n)).intValue() % 2;
            if (checkTest.equals(Integer.valueOf(0))) {
                System.out.println("Przypisanie liczby " + n + " do listy 2: " + numbers.get(n));
                check.add(numbers.get(n));
            }
        }

        System.out.println("\n Wyświetlanie parzystych liczb ze zbioru " + numbers.size() + " elementów... \n");
        Iterator var5 = check.iterator();

        while(var5.hasNext()) {
            checkTest = (Integer)var5.next();
            System.out.println(checkTest);
        }

        System.out.println("\n Liczba parzystych liczb w ArrayList: " + check.size());
        return check.size();
    }
}