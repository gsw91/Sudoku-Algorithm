package com.kodilla.patterns.factory.tasks;

import java.util.LinkedList;
import java.util.List;

public class PaintingTask implements Task {

    private String taskName;
    private String color;
    private String whatToPaint;
    private List<String> paintingTasksList = new LinkedList<>();
    private String newTask;

    public PaintingTask(String taskName, String color, String whatToPaint) {
        this.taskName = taskName;
        this.color = color;
        this.whatToPaint = whatToPaint;
    }

    @Override
    public String executeTask() {
        System.out.println("Executing...");
        newTask = "Name: " + taskName + ", color: " + color + ", what to paint: " + whatToPaint;
        System.out.println(newTask);
        System.out.println("Task is done.");
        paintingTasksList.add(newTask);
        return newTask;
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public boolean isTaskExecuted() {
        if (paintingTasksList.contains(newTask)) {
            return true;
        } else {
            return false;
        }
    }

}
