package com.kodilla.spring.calculator;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CalculatorTestSuite {

    @Test
    public void testAllCalculations() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);
        //When
        calculator.add(2.5,2.5);
        calculator.sub(2.5,2.5);
        calculator.mul(2.5,2.5);
        calculator.div(2.5,2.5);
        //Then
        //do nothing
    }

    @Test
    public void testOnlyAddCalculator() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);
        //When
        double result = calculator.add(2.0,2.5);
        //Then
        Assert.assertEquals(4.5, result, 0.01);
    }

    @Test
    public void testOnlySubCalculator() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = (Calculator)context.getBean("calculator");
        //When
        double result = calculator.sub(4.4,3.6);
        //Then
        Assert.assertEquals(0.8, result, 0.01);
    }

    @Test
    public void testOnlyMulCalculator() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);
        //When
        double result = calculator.mul(2.2,0.5);
        //Then
        Assert.assertEquals(1.1, result, 0.01);
    }

    @Test
    public void testOnlyDivCalculator() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = (Calculator)context.getBean("calculator");
        //When
        double result = calculator.div(5.6,2.0);
        //Then
        Assert.assertEquals(2.8, result, 0.01);
    }


}