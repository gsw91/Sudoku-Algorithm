package com.kodilla.good.patterns.challenges.ex9_4.SuppliersOrdersProcess;


import com.kodilla.good.patterns.challenges.ex9_4.BasicClasses.*;
import com.kodilla.good.patterns.challenges.ex9_4.OrdersService.SupplyRequest;
import com.kodilla.good.patterns.challenges.ex9_4.Producers.SupplierExtraFoodShop;

import java.util.*;


public class ExtraFoodShopRequestRetriever implements RequestRetriever {

    @Override
    public SupplyRequest retrive () {

        SupplierExtraFoodShop supplierExtraFoodShop = new SupplierExtraFoodShop();
        Supplier supplier = supplierExtraFoodShop.getSupplier();

        List<Product> products = supplierExtraFoodShop.getProducts();

        Payment payment = new Payment(products.get(0), 2);
        Payment payment1 = new Payment(products.get(1), 7);

        List<Payment> payments = new LinkedList<>();
        payments.add(payment);
        payments.add(payment1);

        return new SupplyRequest(supplier, products, payments);

    }


}
