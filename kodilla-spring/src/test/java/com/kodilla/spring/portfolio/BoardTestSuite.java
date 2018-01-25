package com.kodilla.spring.portfolio;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardTestSuite {

    @Test
    public void testContext() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);

        //When & Then
        System.out.println("===== Beans list: ==== >>");
        Arrays.stream(context.getBeanDefinitionNames())
                .forEach(System.out::println);
        System.out.println("<< ===== Beans list ====");
    }

    @Test
    public void testTaskAdd() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);
        //When
        TaskList toDoList = board.getToDoList();
        toDoList.addTask("Test1");
        TaskList inProgressList = board.getInProgressList();
        inProgressList.addTask("Test2");
        TaskList doneTaskList = board.getDoneList();
        doneTaskList.addTask("Test3");
        //Then
        Assert.assertEquals("Test1", toDoList.showTask(0));
        Assert.assertEquals("Test2", inProgressList.showTask(0));
        Assert.assertEquals("Test3", doneTaskList.showTask(0));
    }


}
