package com.kodilla.good.patterns.challenges.ex9_4.Information;


import com.kodilla.good.patterns.challenges.ex9_4.BasicClasses.Payment;
import com.kodilla.good.patterns.challenges.ex9_4.BasicClasses.Product;
import com.kodilla.good.patterns.challenges.ex9_4.BasicClasses.Supplier;
import com.kodilla.good.patterns.challenges.ex9_4.OrdersService.SupplyRequest;

import java.util.List;


public class GetInformationOrder implements GetInformation {

    @Override
    public void getInformation(Supplier supplier, List<Product> products, List<Payment> payments) {

        SupplyRequest supplyRequest = new SupplyRequest (supplier, products, payments);

        double toPay = 0;

        for(int i=0; i<payments.size(); i++){
            toPay = toPay + payments.get(i).getPayment();
        }

        toPay = toPay*100;
        toPay = Math.round(toPay);
        toPay = toPay/100;

        if(supplyRequest.getSupplier().equals(supplier)){
            System.out.println("Order accepted. Contact to: " + supplier.getName() + " Phone: " + supplier.getPhone() + " Your payment: " + toPay);
        }

    }


}
