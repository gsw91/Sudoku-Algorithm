package com.kodilla.testing.calculator;

public class Calculator {

    public Integer a;
    public Integer b;

    public Calculator (int a, int b) {
        this.a = a;
        this.b = b;
    }

    public Integer AddAToB () {
        return a + b;
    }
    public Integer SubstractAFromB (){
        return b - a;
    }
}