package com.kodilla.good.patterns.challenges.ex9_4.Producers;


public class ShowSuppliers {

    public void showOferts() {

        SuppliersComparison suppliersComparison = new SuppliersComparison();

        System.out.println("All oferts: ");

        suppliersComparison.getAllSuppliersMap().values().forEach(System.out::println);

    }


}
