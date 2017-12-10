package com.kodilla.testing.shape;

public class Square implements Shape {

    String name = "Square";
    double surface;

    public Square(String name, double surface) {
        this.name = name;
        this.surface = surface;
    }

    @Override
    public String getShapeName(){
        return name;
    }

    @Override
    public double getField(){
        return surface;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Square)) return false;

        Square square = (Square) o;

        if (Double.compare(square.surface, surface) != 0) return false;
        return name.equals(square.name);
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
