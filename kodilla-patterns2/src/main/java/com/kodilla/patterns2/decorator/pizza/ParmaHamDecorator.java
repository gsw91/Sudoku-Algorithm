package com.kodilla.patterns2.decorator.pizza;

public class ParmaHamDecorator extends AbstractPizzaOrderDecorator {
    public ParmaHamDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public double getCost() {
        return super.getCost() + 3.50;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Parma ham";
    }
}
