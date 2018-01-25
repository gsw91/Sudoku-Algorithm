package com.kodilla.spring.portfolio;

import java.util.List;

public class Board {

    private TaskList toDoList;
    private TaskList inProgressList;
    private TaskList doneList;

    public Board(TaskList toDoList, TaskList inProgressList, TaskList doneList) {
        this.toDoList = toDoList;
        this.inProgressList = inProgressList;
        this.doneList = doneList;
    }

    public TaskList getToDoList() {
        return toDoList;
    }

    public TaskList getInProgressList() {
        return inProgressList;
    }

    public TaskList getDoneList() {
        return doneList;
    }

    public List<String> addTask(TaskList taskList, String task) {
        return taskList.addTask(task);
    }

    public String showTask(TaskList taskList, int i) {
        return taskList.showTask(i);
    }

}
