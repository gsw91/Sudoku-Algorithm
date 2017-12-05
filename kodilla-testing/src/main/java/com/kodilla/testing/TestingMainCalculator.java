package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;

public class TestingMainCalculator {
    public static void main(String[] args) {

        Calculator calculator = new Calculator(4,4);
        Integer addResult = calculator.AddAToB();
        Integer substractResult = calculator.SubstractAFromB();

        if (addResult.equals(8)) {
            System.out.println("Adding Test: OK!");
        } else{
            System.out.println("Adding Test: Error!");
        }

        if (substractResult.equals(0)) {
            System.out.println("Substraction Test: OK!");
        } else {
            System.out.println("Substraction test: Error!");
        }

    }
}
