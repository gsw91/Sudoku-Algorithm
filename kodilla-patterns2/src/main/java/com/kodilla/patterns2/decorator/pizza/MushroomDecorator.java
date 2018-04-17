package com.kodilla.patterns2.decorator.pizza;

public class MushroomDecorator extends AbstractPizzaOrderDecorator {
    public MushroomDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public double getCost() {
        return super.getCost() + 2.50;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", mushroom";
    }
}
