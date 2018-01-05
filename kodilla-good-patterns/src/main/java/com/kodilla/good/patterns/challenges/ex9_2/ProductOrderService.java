package com.kodilla.good.patterns.challenges.ex9_2;

public class ProductOrderService {

    private OrderService orderService;
    private ProductsInStore productsInStore;
    private Payment payment;

    public ProductOrderService(OrderService orderService, ProductsInStore productsInStore, Payment payment) {
        this.orderService = orderService;
        this.productsInStore = productsInStore;
        this.payment = payment;
    }

    public OrderDto process(final OrderRequest orderRequest) {
        NewOrderService newOrderService = new NewOrderService();
        boolean isOrdered = newOrderService.order(orderRequest.getUser(), orderRequest.getNewOrder());

        if (isOrdered) {
            payment.calculatePayment(orderRequest);
            return new OrderDto(orderRequest.getUser(), orderRequest.getNewOrder(), true);
        } else {
            return new OrderDto(orderRequest.getUser(), orderRequest.getNewOrder(),false);
        }
    }
}