package com.kodilla.patterns2.decorator.pizza;

public class SalamiDecorator extends AbstractPizzaOrderDecorator {
    public SalamiDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public double getCost() {
        return super.getCost()+2;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", salami";
    }
}
