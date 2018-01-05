package com.kodilla.good.patterns.challenges.ex9_2;

public class Application {
    public static void main (String[] args){

        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest = orderRequestRetriever.order();

        ProductOrderService productOrderService = new ProductOrderService(new NewOrderService(), new Store(), new OrderPayment());
        productOrderService.process(orderRequest);
    }
}
