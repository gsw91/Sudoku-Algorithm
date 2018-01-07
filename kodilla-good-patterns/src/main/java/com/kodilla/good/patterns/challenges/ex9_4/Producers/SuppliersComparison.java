package com.kodilla.good.patterns.challenges.ex9_4.Producers;


import com.kodilla.good.patterns.challenges.ex9_4.BasicClasses.*;

import java.util.*;


public class SuppliersComparison implements Comparison {

    @Override
    public Map getAllSuppliersMap() {
        Map<Integer, Map<Supplier, List<Product>>> suppliersStoreMap = new HashMap<>();

        SupplierExtraFoodShop supplierExtraFoodShop = new SupplierExtraFoodShop();
        SupplierHealthyFood supplierHealthyFood = new SupplierHealthyFood();
        SupplierGlutenFreeShop supplierGlutenFreeShop = new SupplierGlutenFreeShop();

        suppliersStoreMap.put(0, supplierExtraFoodShop.getSupplierMap());
        suppliersStoreMap.put(1, supplierHealthyFood.getSupplierMap());
        suppliersStoreMap.put(2, supplierGlutenFreeShop.getSupplierMap());

        return suppliersStoreMap;

    }


}
