package com.kodilla.testing.collection;

import java.util.ArrayList;

public class OddNumbersExterminator {

    ArrayList<Integer> check = new ArrayList();

    public ArrayList<Integer> exterminate(ArrayList<Integer> numbers) {

        Integer checkTest;

          if (numbers.size() == 0){
              System.out.println("Lista jest pusta!");
          }

          if (numbers.size() != 0) {

              for (int n = 0; n < numbers.size(); ++n) {
                  checkTest = (numbers.get(n)) % 2;
                  if (checkTest.equals(0)) {
                      System.out.println("Przypisanie parzystej liczby " + numbers.get(n) + " do nowej listy.");
                      check.add(numbers.get(n));
                  } else if (checkTest != 0) {
                      System.out.println("Pominięcie nieparzystej liczby: " + numbers.get(n));
                  }
              }

              System.out.println("\n Wyświetlanie parzystych liczb ze zbioru " + numbers.size() + " elementów... \n");

              for (int i = 0; i < check.size(); i++) {
                  System.out.println(check.get(i));
              }
              System.out.println("\n Liczba parzystych liczb w nowej ArrayList: " + check.size());
          }
          return check;
      }
}