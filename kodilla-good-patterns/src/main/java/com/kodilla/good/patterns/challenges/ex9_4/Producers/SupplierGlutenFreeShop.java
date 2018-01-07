package com.kodilla.good.patterns.challenges.ex9_4.Producers;


import com.kodilla.good.patterns.challenges.ex9_4.BasicClasses.*;

import java.util.*;


public class SupplierGlutenFreeShop implements AddingNewSupplier {

    @Override
    public Supplier getSupplier() {
        return new Supplier("Gluten Free Shop", "Cracow", "321321321");
    }

    @Override
    public Map<Supplier, List<Product>> getSupplierMap() {

        Map<Supplier, List<Product>> supplierMap = new HashMap<>();
        List<Product> productsList = new LinkedList<>();

        Supplier glutenFreeShop = getSupplier();
        Product gfsFlour = new Product("Gluten free flour", 12, 29.49);

        productsList.add(gfsFlour);

        supplierMap.put(glutenFreeShop, productsList);

        return supplierMap;

    }

    @Override
    public List<Product> getProducts() {

        List<Product> products = getSupplierMap().get(getSupplier());

        return products;

    }


}

