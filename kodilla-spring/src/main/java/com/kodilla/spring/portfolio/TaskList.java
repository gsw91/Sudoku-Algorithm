package com.kodilla.spring.portfolio;

import java.util.ArrayList;
import java.util.List;

public class TaskList {

    private List<String> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public List<String> addTask(String newTask) {
        tasks.add(newTask);
        return tasks;
    }

    public String showTask (int i) {
        return tasks.get(i);
    }

}
