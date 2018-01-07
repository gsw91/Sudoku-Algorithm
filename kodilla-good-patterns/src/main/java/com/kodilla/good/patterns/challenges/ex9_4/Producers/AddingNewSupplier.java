package com.kodilla.good.patterns.challenges.ex9_4.Producers;


import com.kodilla.good.patterns.challenges.ex9_4.BasicClasses.*;

import java.util.*;


public interface AddingNewSupplier {

    Supplier getSupplier();

    Map<Supplier, List<Product>> getSupplierMap();

    List<Product> getProducts();


}
