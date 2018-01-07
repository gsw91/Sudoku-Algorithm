package com.kodilla.good.patterns.challenges.ex9_4.OrdersService;


import com.kodilla.good.patterns.challenges.ex9_4.BasicClasses.*;
import java.util.List;


public class SupplyRequest {

    public Supplier supplier;
    public List<Product> products;
    public List<Payment> payments;

    public SupplyRequest(Supplier supplier, List<Product> products, List<Payment> payments) {
        this.supplier = supplier;
        this.products = products;
        this.payments = payments;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<Payment> getPayments() {
        return payments;
    }


}
