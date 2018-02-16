package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public class Ingredients {

    public final static String LETTUCE = "LETTUCE";
    public final static String ONION = "ONION";
    public final static String BACON = "BACON";
    public final static String CUCUMBER = "CUCUMBER";
    public final static String CHILI = "CHILI";
    public final static String MUSHROOMS = "MUSHROOMS";
    public final static String SHRIMP = "SHRIMP";
    public final static String CHEESE = "CHEESE";
    private List<String> ingredients = new ArrayList<>();

    public Ingredients(String... ingredients) {
        for (String ingredient : ingredients) {
            switch (ingredient) {
                case LETTUCE:
                    this.ingredients.add(LETTUCE);
                    break;
                case ONION:
                    this.ingredients.add(ONION);
                    break;
                case BACON:
                    this.ingredients.add(BACON);
                    break;
                case CUCUMBER:
                    this.ingredients.add(CUCUMBER);
                    break;
                case CHILI:
                    this.ingredients.add(CHILI);
                    break;
                case MUSHROOMS:
                    this.ingredients.add(MUSHROOMS);
                    break;
                case SHRIMP:
                    this.ingredients.add(SHRIMP);
                    break;
                case CHEESE:
                    this.ingredients.add(CHEESE);
                    break;
                default:
                    throw new IllegalStateException(ingredient + " - incorrect ingredient!");
            }
        }
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "Ingredients " + ingredients;
    }
}
