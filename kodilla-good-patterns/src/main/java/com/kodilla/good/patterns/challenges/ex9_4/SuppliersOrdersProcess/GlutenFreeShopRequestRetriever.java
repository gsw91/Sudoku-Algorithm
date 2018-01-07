package com.kodilla.good.patterns.challenges.ex9_4.SuppliersOrdersProcess;


import com.kodilla.good.patterns.challenges.ex9_4.BasicClasses.*;
import com.kodilla.good.patterns.challenges.ex9_4.OrdersService.SupplyRequest;
import com.kodilla.good.patterns.challenges.ex9_4.Producers.SupplierGlutenFreeShop;

import java.util.*;


public class GlutenFreeShopRequestRetriever implements RequestRetriever {

    @Override
    public SupplyRequest retrive() {

        SupplierGlutenFreeShop supplierGlutenFreeShop = new SupplierGlutenFreeShop();
        Supplier supplier = supplierGlutenFreeShop.getSupplier();

        List<Product> products = supplierGlutenFreeShop.getProducts();

        Payment payment = new Payment(products.get(0), 21);

        List<Payment> payments = new LinkedList<>();
        payments.add(payment);

        return new SupplyRequest(supplier, products, payments);

    }


}
