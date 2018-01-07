package com.kodilla.good.patterns.challenges.ex9_4.BasicClasses;


public class Supplier {
    private final String name;
    private final String city;
    private final String phone;

    public Supplier(final String name, final String city, final String phone) {
        this.name = name;
        this.city = city;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Supplier)) return false;

        Supplier supplier = (Supplier) o;

        if (!getName().equals(supplier.getName())) return false;
        if (!getCity().equals(supplier.getCity())) return false;
        return getPhone().equals(supplier.getPhone());
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getCity().hashCode();
        result = 31 * result + getPhone().hashCode();
        return result;
    }


}
