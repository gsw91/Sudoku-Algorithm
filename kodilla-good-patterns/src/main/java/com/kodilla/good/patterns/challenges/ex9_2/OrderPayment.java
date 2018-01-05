package com.kodilla.good.patterns.challenges.ex9_2;

import java.util.ArrayList;
import java.util.List;

public class OrderPayment implements Payment {
    @Override
    public double calculatePayment(OrderRequest orderRequest) {

        Store store = new Store();

        List<Book> books = store.booksInStore();
        List<Game> games = store.gamesInStore();
        List<Phone> phones = store.phonesInStore();

        double b = books.stream()
                .filter(t -> orderRequest.getNewOrder().contains(t))
                .mapToDouble(i -> i.getPrice())
                .sum();

        double g = games.stream()
                .filter(t -> orderRequest.getNewOrder().contains(t))
                .mapToDouble(i -> i.getPrice())
                .sum();

        double p = phones.stream()
                .filter(t -> orderRequest.getNewOrder().contains(t))
                .mapToDouble(i -> i.getPrice())
                .sum();

        double sum = b + g + p;

        System.out.println("To pay: " + sum);

        return sum;
    }
}
