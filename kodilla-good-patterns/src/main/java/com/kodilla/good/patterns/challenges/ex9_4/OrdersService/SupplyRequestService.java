package com.kodilla.good.patterns.challenges.ex9_4.OrdersService;


import com.kodilla.good.patterns.challenges.ex9_4.BasicClasses.*;

import java.util.List;


public class SupplyRequestService implements SupplyService {

    @Override
    public boolean createSupply(Supplier supplier, List<Payment> payments) {

        System.out.println("New order to: " + supplier.getName() + " from: " + supplier.getCity()
                    + " Ordered products: " + payments);

        return true;

    }


}
