package com.kodilla.testing.shape;

import java.util.ArrayList;

public class ShapeCollector {

    private ArrayList<Shape> shapes = new ArrayList<>();

    public ShapeCollector(ArrayList<Shape> shapes) {
        this.shapes = shapes;
    }

    public void addFigure(Shape shape) {

    }

    public boolean removeFigure(Shape shape) {
        return true;
    }

    public Shape getFigure(int numberOfFigure) {
        return null;
    }

    public ArrayList<Shape> showFigures() {
        return null;
    }

    public ArrayList<Shape> getShapes() {
        return null;
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
