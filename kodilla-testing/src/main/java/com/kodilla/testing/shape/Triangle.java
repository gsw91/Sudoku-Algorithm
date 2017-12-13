package com.kodilla.testing.shape;

public class Triangle implements Shape{
    String name;
    double surface;

    public Triangle (String name, double surface) {
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
    public  String getShapeName(){
        return getName();
    }

    @Override
    public double getField(){
        return getSurface();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Triangle)) return false;

        Triangle triangle = (Triangle) o;

        if (Double.compare(triangle.surface, surface) != 0) return false;
        return name.equals(triangle.name);
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

