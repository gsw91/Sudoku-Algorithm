package com.kodilla.good.patterns.challenges.ex9_4;


import com.kodilla.good.patterns.challenges.ex9_4.Information.GetInformationOrder;
import com.kodilla.good.patterns.challenges.ex9_4.OrdersService.*;
import com.kodilla.good.patterns.challenges.ex9_4.Producers.ShowSuppliers;
import com.kodilla.good.patterns.challenges.ex9_4.SuppliersOrdersProcess.*;


public class Application {

    public static void main(String[] args) {

        ShowSuppliers showSuppliers = new ShowSuppliers();
        showSuppliers.showOferts();

        ExtraFoodShopProcess extraFoodShopProcess = new ExtraFoodShopProcess(new SupplyRequestService(), new GetInformationOrder());
        extraFoodShopProcess.process();

        GlutenFreeShopProcess glutenFreeShopProcess = new GlutenFreeShopProcess(new SupplyRequestService(), new GetInformationOrder());
        glutenFreeShopProcess.process();

        HealthyFoodProcess healthyFoodProcess = new HealthyFoodProcess(new SupplyRequestService(), new GetInformationOrder());
        healthyFoodProcess.process();

    }


}