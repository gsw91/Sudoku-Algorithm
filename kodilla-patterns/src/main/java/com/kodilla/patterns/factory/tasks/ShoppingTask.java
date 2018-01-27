package com.kodilla.patterns.factory.tasks;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ShoppingTask implements Task {

    private String taskName;
    private String whatToBuy;
    private double quantity;
    private List<String> shoppingTasksList = new LinkedList<>();
    private String newTask;

    public ShoppingTask(String taskName, String whatToBuy, double quantity) {
        this.taskName = taskName;
        this.whatToBuy = whatToBuy;
        this.quantity = quantity;
    }

    @Override
    public String executeTask() {
        System.out.println("Executing...");
        newTask = "Name: " + taskName + ", to buy: " + whatToBuy + ", quantity: " + quantity;
        System.out.println(newTask);
        System.out.println("Task is done.");
        shoppingTasksList.add(newTask);
        return newTask;
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public boolean isTaskExecuted() {
        if (shoppingTasksList.contains(newTask)) {
            return true;
        } else {
            return false;
        }
    }

}
