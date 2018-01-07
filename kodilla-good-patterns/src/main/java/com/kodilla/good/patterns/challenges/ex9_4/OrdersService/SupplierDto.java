package com.kodilla.good.patterns.challenges.ex9_4.OrdersService;


import com.kodilla.good.patterns.challenges.ex9_4.BasicClasses.Supplier;


public class SupplierDto {
    public Supplier supplier;
    public boolean isOrdered;

    public SupplierDto(Supplier supplier, boolean isOrdered) {
        this.supplier = supplier;
        this.isOrdered = isOrdered;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public boolean isOrdered() {
        return isOrdered;
    }


}
