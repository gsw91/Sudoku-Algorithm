package com.kodilla.good.patterns.challenges.ex9_4.SuppliersOrdersProcess;


import com.kodilla.good.patterns.challenges.ex9_4.BasicClasses.*;
import com.kodilla.good.patterns.challenges.ex9_4.OrdersService.SupplyRequest;
import com.kodilla.good.patterns.challenges.ex9_4.Producers.SupplierHealthyFood;

import java.util.*;


public class HealthyFoodRequestRetriever implements RequestRetriever {

    @Override
    public SupplyRequest retrive() {
        SupplierHealthyFood supplierHealthyFood = new SupplierHealthyFood();
        Supplier supplier = supplierHealthyFood.getSupplier();

        List<Product> products = supplierHealthyFood.getProducts();

        Payment payment = new Payment(products.get(0), 37);
        Payment payment1 = new Payment(products.get(1), 81);

        List<Payment> payments = new LinkedList<>();
        payments.add(payment);
        payments.add(payment1);

        return new SupplyRequest(supplier, products, payments);

    }


}
