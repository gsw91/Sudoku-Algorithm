package com.kodilla.good.patterns.challenges.ex9_4.BasicClasses;


public class Product {
    private final String productName;
    private final long quantityInOneUnit;
    private final double priceForOneUnit;

    public Product(final String productName, final long quantityInOneUnit, final double priceForOneUnit) {
        this.productName = productName;
        this.quantityInOneUnit = quantityInOneUnit;
        this.priceForOneUnit = priceForOneUnit;
    }

    public String getProductName() {
        return productName;
    }

    public long getQuantity1Pack() {
        return quantityInOneUnit;
    }

    public double getPrice1Pack() {
        return priceForOneUnit;
    }

    @Override
    public String toString() {
        return  "ProductName= " + productName +
                ", quantity1Pack= " + quantityInOneUnit +
                ", price1Pack= " + priceForOneUnit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        if (getQuantity1Pack() != product.getQuantity1Pack()) return false;
        if (Double.compare(product.getPrice1Pack(), getPrice1Pack()) != 0) return false;
        return getProductName().equals(product.getProductName());
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getProductName().hashCode();
        result = 31 * result + (int) (getQuantity1Pack() ^ (getQuantity1Pack() >>> 32));
        temp = Double.doubleToLongBits(getPrice1Pack());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }


}
