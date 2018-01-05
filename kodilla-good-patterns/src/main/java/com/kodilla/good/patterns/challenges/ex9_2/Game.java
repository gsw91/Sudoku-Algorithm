package com.kodilla.good.patterns.challenges.ex9_2;

public class Game {
    private final String name;
    private final String console;
    private final double price;

    public Game(final String name,final String console,final double price) {
        this.name = name;
        this.console = console;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getConsole() {
        return console;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                ", console='" + console + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Game)) return false;

        Game game = (Game) o;

        if (Double.compare(game.price, price) != 0) return false;
        if (!name.equals(game.name)) return false;
        return console.equals(game.console);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name.hashCode();
        result = 31 * result + console.hashCode();
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
