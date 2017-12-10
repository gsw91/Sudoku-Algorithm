package com.kodilla.testing.shape;

public class Circle implements Shape {

    String name;
    double surface;

    public Circle(String name, double surface) {
        this.name = name;
        this.surface = surface;
    }

    public String getName() {
        return name;
    }

    public double getSurface() {
        return surface;
    }

    @Override
    public String getShapeName(){
        return getName();
    }

    @Override
    public double getField(){
        return getSurface();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Circle)) return false;

        Circle circle = (Circle) o;

        if (Double.compare(circle.surface, surface) != 0) return false;
        return name.equals(circle.name);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name.hashCode();
        temp = Double.doubleToLongBits(surface);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}


