package com.kodilla.patterns2.observer.homework;

import java.util.ArrayList;
import java.util.List;

public class CourseTasks implements Observable {

    private final String name;
    private final List<StudentTask> studentTasks;
    private List<Observer> observers;

    public CourseTasks(String name) {
        this.observers = new ArrayList<>();
        this.studentTasks = new ArrayList<>();
        this.name = name;
    }

    public void addTask(StudentTask studentTask) {
        studentTasks.add(studentTask);
        notifyObservers();
    }


    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer: observers) {
            observer.update(this);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public String getName() {
        return name;
    }

    public List<StudentTask> getStudentTasks() {
        return studentTasks;
    }

    public List<Observer> getObservers() {
        return observers;
    }
}
