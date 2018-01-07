package com.kodilla.good.patterns.challenges.ex9_4.SuppliersOrdersProcess;


import com.kodilla.good.patterns.challenges.ex9_4.Information.GetInformation;
import com.kodilla.good.patterns.challenges.ex9_4.OrdersService.*;


public class HealthyFoodProcess {

    private SupplyService supplyService;
    private GetInformation getInformation;

    public HealthyFoodProcess(SupplyService supplyService, GetInformation getInformation) {
        this.supplyService = supplyService;
        this.getInformation = getInformation;
    }

    public SupplierDto process(){

        HealthyFoodRequestRetriever healthyFoodRequestRetriever = new HealthyFoodRequestRetriever();
        SupplyRequest supplyRequest = healthyFoodRequestRetriever.retrive();

        boolean isOrdered = supplyService.createSupply(supplyRequest.getSupplier(), supplyRequest.getPayments());

        if (isOrdered) {
            getInformation.getInformation(supplyRequest.getSupplier(), supplyRequest.getProducts(), supplyRequest.getPayments());
            return new SupplierDto(supplyRequest.getSupplier(), true);
        } else {
            return new SupplierDto(supplyRequest.getSupplier(), false);
        }

    }


}
