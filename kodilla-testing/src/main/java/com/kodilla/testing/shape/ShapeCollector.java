package com.kodilla.testing.shape;

import java.util.ArrayList;

public class ShapeCollector {

    private ArrayList<Shape> shapes = new ArrayList<>();
    String figures;

    public ShapeCollector(ArrayList<Shape> shapes) {
        this.shapes = shapes;
    }


    public void addFigure(Shape shape) {
        shapes.add(shape);
    }

    public boolean removeFigure(Shape shape) {
        boolean result = false;
        if (shapes.contains(shape)) {
            shapes.remove(shape);
            result = true;
        }
        return result;
    }

    public Shape getFigure(int numberOfFigure) {
        Shape figure = shapes.get(numberOfFigure);
        return figure;
    }

    public String showFigures() {
        for (int i = 0; i<shapes.size() ; i++) {
            figures = String.valueOf(shapes.get(i));
            if (figures.contains("Circle")) {
                System.out.println("The figure number: " + i + " is " + shapes.get(i).getShapeName() +
                " ,the field of this figure is: " + shapes.get(i).getField());
            } else {
            if (figures.contains("Square")) {
                System.out.println("The figure number: " + i + " is " + shapes.get(i).getShapeName() +
                        " ,the field of this figure is: " + shapes.get(i).getField());
            } else {
            if (figures.contains("Triangle")) {
                System.out.println("The figure number: " + i + " is " + shapes.get(i).getShapeName() +
                        " ,the field of this figure is: " + shapes.get(i).getField());
            }}}
        }
        return figures;
    }

    public ArrayList<Shape> getShapes () { return shapes; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShapeCollector)) return false;

        ShapeCollector that = (ShapeCollector) o;

        if (!getShapes().equals(that.getShapes())) return false;
        return figures.equals(that.figures);
    }

    @Override
    public int hashCode() {
        int result = getShapes().hashCode();
        result = 31 * result + figures.hashCode();
        return result;
    }
}



