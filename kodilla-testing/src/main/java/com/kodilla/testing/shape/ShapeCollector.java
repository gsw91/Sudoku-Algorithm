package com.kodilla.testing.shape;

import java.util.ArrayList;

public class ShapeCollector {

    ArrayList<Shape> shapes = new ArrayList<>();

    public ShapeCollector(ArrayList<Shape> shapes) {
        this.shapes = shapes;
    }

    public void addFigure (Shape shape){
    }

    public boolean removeFigure (Shape shape){
        return true ;
    }

    public int getFigure (int n){
        return 1;
    }

    public String showFigures(String name){
        return "Error";
    }

    public ArrayList<Shape> getShapes() {
        return shapes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShapeCollector)) return false;

        ShapeCollector that = (ShapeCollector) o;

        return getShapes().equals(that.getShapes());
    }

    @Override
    public int hashCode() {
        return getShapes().hashCode();
    }
}
