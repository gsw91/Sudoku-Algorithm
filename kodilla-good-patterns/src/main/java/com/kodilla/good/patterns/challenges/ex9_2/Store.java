package com.kodilla.good.patterns.challenges.ex9_2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Store implements ProductsInStore {

    @Override
    public final List<Book> booksInStore() {
        List<Book> booksList = new LinkedList<>();
        booksList.add(new Book("Czysty kod", "Martin Robert C.", 39.99));
        booksList.add(new Book("Zwinne wytwarzanie oprogramowania", "Martin Robert C.", 64.99));
        booksList.add(new Book("Sekret, którego nie zdradzę", "Tess Gerritsen", 25.00));
        booksList.add(new Book("Czarownica", "Camilla Läckberg", 34.49));

        return booksList;
    }

    @Override
    public final List<Game> gamesInStore() {
        List<Game> gamesList = new LinkedList<>();
        gamesList.add(new Game("Counter Strike Global Offensive", "PC", 49.99));
        gamesList.add(new Game("Europa Universalis 4", "PC", 120.00));
        gamesList.add(new Game("Fifa 2017", "Xbox One",119.99));
        gamesList.add(new Game("Wiedźmin: Dziki gon", "PS4", 149.99));

        return gamesList;
    }

    @Override
    public final List<Phone> phonesInStore() {
        List<Phone> phonesList = new LinkedList<>();
        phonesList.add(new Phone("Huawei", "P10", 1799.00));
        phonesList.add(new Phone("Samsung", "Galaxy S8", 2699.00));

        return phonesList;
    }
}
