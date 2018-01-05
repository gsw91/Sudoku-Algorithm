package com.kodilla.good.patterns.challenges.ex9_2;

import java.util.ArrayList;
import java.util.List;

public class OrderPayment implements Payment {
    @Override
    public double calculatePayment(OrderRequest orderRequest) {

        double calculationBooks = 0;
        double calculationGames = 0;
        double calculationPhones = 0;

        Store store = new Store();

        List<Book> books = store.booksInStore();
        List<Game> games = store.gamesInStore();
        List<Phone> phones = store.phonesInStore();

        for (int i = 0; i < books.size(); i++) {
            if (orderRequest.getNewOrder().contains(books.get(i))) {
                calculationBooks = calculationBooks + books.get(i).getPrice();
            }
        }

        for (int t = 0; t < games.size(); t++) {
            if (orderRequest.getNewOrder().contains(games.get(t))) {
                calculationGames = calculationGames + games.get(t).getPrice();
            }
        }

        for (int z = 0; z < phones.size(); z++) {
            if (orderRequest.getNewOrder().contains(phones.get(z))) {
                calculationPhones = calculationPhones + phones.get(z).getPrice();
            }
        }

        double calculatedAmount = calculationBooks + calculationGames + calculationPhones;

        System.out.println("To pay: " + calculatedAmount);

        return calculatedAmount;
    }
}
