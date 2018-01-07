package com.kodilla.good.patterns.challenges.ex9_4.Producers;


import com.kodilla.good.patterns.challenges.ex9_4.BasicClasses.*;

import java.util.*;


public class SupplierExtraFoodShop implements AddingNewSupplier {

    @Override
    public Supplier getSupplier() {
        return new Supplier("Extra Food Shop", "Cracow", "123123123");
    }

    @Override
    public Map<Supplier, List<Product>> getSupplierMap() {

        Map<Supplier, List<Product>> supplierMap = new HashMap<>();
        List<Product> productsList = new LinkedList<>();

        Supplier extraFoodShop = getSupplier();
        Product efsMilk = new Product("Cow Milk 1L", 12, 23.99);
        Product efsCheese = new Product("Cheese 250g", 24, 59.99);

        productsList.add(efsMilk);
        productsList.add((efsCheese));

        supplierMap.put(extraFoodShop, productsList);

        return supplierMap;
    }

    @Override
    public List<Product> getProducts() {

        List<Product> products = getSupplierMap().get(getSupplier());

        return products;

    }


}
