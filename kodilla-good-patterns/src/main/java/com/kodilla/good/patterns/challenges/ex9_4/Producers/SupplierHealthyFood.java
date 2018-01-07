package com.kodilla.good.patterns.challenges.ex9_4.Producers;


import com.kodilla.good.patterns.challenges.ex9_4.BasicClasses.*;

import java.util.*;


public class SupplierHealthyFood implements AddingNewSupplier {

    @Override
    public Supplier getSupplier() {
        return new Supplier("Healthy Shop", "Wieliczka", "213213213");
    }

    @Override
    public Map<Supplier, List<Product>> getSupplierMap() {

        Map<Supplier, List<Product>> supplierMap = new HashMap<>();
        List<Product> productsList = new LinkedList<>();

        Supplier healthyShop = getSupplier();
        Product hsBread = new Product("Bread", 24, 23.99);
        Product hsRolls = new Product("Rolls", 24, 11.49);

        productsList.add(hsBread);
        productsList.add((hsRolls));

        supplierMap.put(healthyShop, productsList);

        return supplierMap;

    }

    @Override
    public List<Product> getProducts() {

        List<Product> products = getSupplierMap().get(getSupplier());

        return products;

    }


}
