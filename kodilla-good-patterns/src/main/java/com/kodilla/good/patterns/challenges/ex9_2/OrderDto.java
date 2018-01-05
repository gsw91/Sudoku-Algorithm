package com.kodilla.good.patterns.challenges.ex9_2;

import java.util.List;

public class OrderDto {
    private User user;
    private List newOrder;
    private boolean isOrdered;

    public OrderDto(User user, List newOrder, boolean isOrdered) {
        this.user = user;
        this.newOrder = newOrder;
        this.isOrdered = isOrdered;
    }

    public User getUser() {
        return user;
    }

    public List getNewOrder() {
        return newOrder;
    }

    public boolean isOrdered() {
        return isOrdered;
    }
}
