package com.kodilla.patterns.factory.tasks;

public class TaskFactory {

    public static final String DRIVING = "DRIVING";
    public static final String PAINTING = "PAINTING";
    public static final String SHOPPING = "SHOPPING";

    public final Task makeTask(final String kindOfTask) {
        switch (kindOfTask) {
            case DRIVING:
                return new DrivingTask("Trip", "to Boston", "Fiat 126p");
            case PAINTING:
                return new PaintingTask("New painting", "Green", "Grass");
            case SHOPPING:
                return new ShoppingTask("Go shopping", "Bread", 100);
            default:
                return null;
        }
    }

}
