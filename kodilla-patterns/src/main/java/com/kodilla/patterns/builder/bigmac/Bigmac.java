package com.kodilla.patterns.builder.bigmac;

public final class Bigmac {
    private final Roll roll;
    private final Burgers burgers;
    private final Sauce sauce;
    private final Ingredients ingredients;

    private Bigmac(final Roll roll, final Burgers burgers, final Sauce sauce, final Ingredients ingredients) {
        this.roll = roll;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingredients = ingredients;
    }

    public static class BigmacBuilder {
        private Roll roll;
        private Burgers burgers;
        private Sauce sauce;
        private Ingredients ingredients;

        public BigmacBuilder chooseRoll(Roll roll) {
            this.roll = roll;
            return this;
        }

        public BigmacBuilder chooseBurgers(Burgers burgers) {
            this.burgers = burgers;
            return this;
        }

        public BigmacBuilder chooseSauce(Sauce sauce) {
            this.sauce = sauce;
            return this;
        }

        public BigmacBuilder chooseIngredients(Ingredients ingredients) {
            this.ingredients = ingredients;
            return this;
        }

        public Bigmac build () {
            return new Bigmac(roll, burgers, sauce, ingredients);
        }
    }

    public Roll getRoll() {
        return roll;
    }

    public Burgers getBurgers() {
        return burgers;
    }

    public Sauce getSauce() {
        return sauce;
    }

    public Ingredients getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "Your bigmac: \n" + roll + "\n"
                + burgers + "\n" + sauce + "\n"
                + ingredients;
    }
}
