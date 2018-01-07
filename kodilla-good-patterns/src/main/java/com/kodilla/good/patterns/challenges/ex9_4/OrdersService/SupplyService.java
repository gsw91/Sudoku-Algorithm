package com.kodilla.good.patterns.challenges.ex9_4.OrdersService;


import com.kodilla.good.patterns.challenges.ex9_4.BasicClasses.*;

import java.util.List;


public interface SupplyService {

    boolean createSupply (Supplier supplier, List<Payment> payments);


}
