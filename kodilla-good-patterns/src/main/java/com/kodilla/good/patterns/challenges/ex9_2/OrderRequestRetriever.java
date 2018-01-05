package com.kodilla.good.patterns.challenges.ex9_2;

import java.util.ArrayList;
import java.util.List;

public class OrderRequestRetriever {

    public OrderRequest order () {

        User user = new User ("Grzegorz", "Wójcik", "g.wojcik@vp.pl");

        Store store = new Store();

        List<Object> newOrder = new ArrayList<>();
        newOrder.add(store.phonesInStore().get(1));
        newOrder.add(store.gamesInStore().get(2));
        newOrder.add(store.booksInStore().get(1));
        newOrder.add(store.booksInStore().get(0));

        return new OrderRequest(user, newOrder);
    }
}
