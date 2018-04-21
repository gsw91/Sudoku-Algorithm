package com.kodilla.patterns2.observer.homework;

public class Menthor implements Observer {
    private final String name;
    private int updateCount;

    public Menthor(String name) {
        this.name = name;
    }

    @Override
    public void update(CourseTasks courseTasks) {
        System.out.println("Hello " + name + " \nNew task from: " + courseTasks.getName() + "\n" +
                "Total tasks to check: " + courseTasks.getStudentTasks().size() + "\n");
        updateCount++;
    }

    public String getName() {
        return name;
    }

    public int getUpdateCount() {
        return updateCount;
    }
}
