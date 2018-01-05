package com.kodilla.good.patterns.challenges.ex9_2;

import java.util.List;

public class NewOrderService implements OrderService {

    @Override
    public boolean order(final User user, final List newOrder) {

        System.out.println("Create new order for: " + user.getName() + " "+ user.getSurname()
                + ". Ordered items: " + newOrder.size() + " : ");

        for (int i=0; i<newOrder.size(); i++) {
            System.out.println(newOrder.get(i).toString());
        }

        return true;
    }
}
