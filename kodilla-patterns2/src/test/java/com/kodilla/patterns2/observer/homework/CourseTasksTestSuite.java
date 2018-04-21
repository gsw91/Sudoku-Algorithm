package com.kodilla.patterns2.observer.homework;

import org.junit.Test;

import static org.junit.Assert.*;

public class CourseTasksTestSuite {

    @Test
    public void testObserverPattern() {
        //Given
        TasksModule10 module10 = new TasksModule10();
        TasksModule11 module11 = new TasksModule11();
        Menthor johnSmith = new Menthor("John Smith");
        Menthor johnKovalsky = new Menthor("John Kovalsky");
        module10.registerObserver(johnSmith);
        module11.registerObserver(johnSmith);
        module11.registerObserver(johnKovalsky);
        //When
        module10.addTask(new StudentTask("johnWoycik", new CompletedTask("Task 10/1", "www.github.com")));
        module10.addTask(new StudentTask("johnWoycik", new CompletedTask("Task 10/3", "www.github.com")));
        module11.addTask(new StudentTask("arnoldSchweirer", new CompletedTask("Task 11/5", "www.github.com")));
        //Then
        assertEquals(2, module10.getStudentTasks().size());
        assertEquals(1, module11.getStudentTasks().size());
        assertEquals(3, johnSmith.getUpdateCount());
        assertEquals(1, johnKovalsky.getUpdateCount());
        assertEquals(1, module10.getObservers().size());
        assertEquals(2, module11.getObservers().size());
        //&Then
        module11.removeObserver(johnKovalsky);
        assertEquals(1, module11.getObservers().size());
    }

}