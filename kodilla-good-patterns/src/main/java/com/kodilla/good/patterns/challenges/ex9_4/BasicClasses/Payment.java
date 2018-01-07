package com.kodilla.good.patterns.challenges.ex9_4.BasicClasses;


public class Payment {

    private final Product product;
    private final int quantityUnits;

    public Payment(Product product, int quantityUnits) {
        this.product = product;
        this.quantityUnits = quantityUnits;
    }

    public int getQuantityUnits() {
        return quantityUnits;
    }

    public Product getProduct() {
        return product;
    }

    public double getPayment() {
        double payment = getProduct().getPrice1Pack() * getQuantityUnits();

        payment = payment*100;
        payment = Math.round(payment);
        payment = payment/100;

        return payment;
    }

    @Override
    public String toString() {
        return "Product: " + getProduct().getProductName() + ", quantityUnits= " + quantityUnits +
                ", price: " + getPayment();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payment)) return false;

        Payment payment = (Payment) o;

        if (getQuantityUnits() != payment.getQuantityUnits()) return false;
        return getProduct().equals(payment.getProduct());
    }

    @Override
    public int hashCode() {
        int result = getProduct().hashCode();
        result = 31 * result + getQuantityUnits();
        return result;
    }


}
