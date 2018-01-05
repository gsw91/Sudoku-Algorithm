package com.kodilla.good.patterns.challenges.ex9_2;

import java.util.List;

public class OrderRequest {
    public User user;
    public List newOrder;

    public OrderRequest(final User user, final List newOrder) {
        this.user = user;
        this.newOrder = newOrder;
    }

    public User getUser() {
        return user;
    }

    public List getNewOrder() {
        return newOrder;
    }
}
