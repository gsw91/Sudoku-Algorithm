package com.kodilla.patterns.factory.tasks;

import java.util.LinkedList;
import java.util.List;

public class DrivingTask implements Task{

    private String taskName;
    private String where;
    private String using;
    private List<String> drivingTasksList = new LinkedList<>();
    private String newTask;

    public DrivingTask(String taskName, String where, String using) {
        this.taskName = taskName;
        this.where = where;
        this.using = using;
    }

    @Override
    public String executeTask() {
        System.out.println("Executing...");
        newTask = "Name: " + taskName + ", place to go: " + where + ", vehicle: " + using;
        System.out.println(newTask);
        System.out.println("Task is done.");
        drivingTasksList.add(newTask);
        return newTask;
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public boolean isTaskExecuted() {
        if (drivingTasksList.contains(newTask)) {
            return true;
        } else {
            return false;
        }
    }

}
