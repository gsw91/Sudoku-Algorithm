package com.kodilla.patterns2.decorator.pizza;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PizzaDecoratorTestSuite {

    @Test
    public void testPizzaOrderWithNoIngredients() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        //When
        double cost = pizzaOrder.getCost();
        String description = pizzaOrder.getDescription();
        //Then
        assertEquals(15, cost, 0.01);
        assertEquals("Pizza with cheese, tomato sauce", description);
    }

    @Test
    public void testPizzaOrderWithParmaHamMushroomSalami() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new ParmaHamDecorator(pizzaOrder);
        pizzaOrder = new MushroomDecorator(pizzaOrder);
        pizzaOrder = new SalamiDecorator(pizzaOrder);
        //When
        double cost = pizzaOrder.getCost();
        String description = pizzaOrder.getDescription();
        //Then
        assertEquals(23.00, cost, 0.01);
        assertEquals("Pizza with cheese, tomato sauce, Parma ham, mushroom, salami", description);
    }

    @Test
    public void testPizzaOrderWithTripleParmaHam() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new ParmaHamDecorator(pizzaOrder);
        pizzaOrder = new ParmaHamDecorator(pizzaOrder);
        pizzaOrder = new ParmaHamDecorator(pizzaOrder);
        //When
        double cost = pizzaOrder.getCost();
        String description = pizzaOrder.getDescription();
        //Then
        assertEquals(25.50, cost, 0.01);
        assertEquals("Pizza with cheese, tomato sauce, Parma ham, Parma ham, Parma ham", description);
    }

}
