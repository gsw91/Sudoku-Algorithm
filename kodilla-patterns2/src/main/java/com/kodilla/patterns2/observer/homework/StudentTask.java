package com.kodilla.patterns2.observer.homework;

public class StudentTask {
    private final String studentName;
    private final CompletedTask completedTask;

    public StudentTask(String studentName, CompletedTask completedTask) {
        this.studentName = studentName;
        this.completedTask = completedTask;
    }

    public String getStudentName() {
        return studentName;
    }

    public CompletedTask getCompletedTask() {
        return completedTask;
    }
}
