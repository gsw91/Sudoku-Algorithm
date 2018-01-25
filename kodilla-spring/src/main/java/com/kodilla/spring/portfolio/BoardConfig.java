package com.kodilla.spring.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;

@Configuration
public class BoardConfig {

    @Bean
    public Board getBoard(){
        return new Board(addToDoList(), addInProgressList(), addDoneList());
    }

    @Bean(name = "toDoList")
    public TaskList addToDoList() {
        return new TaskList();
    }

    @Bean(name = "inProgressList")
    public TaskList addInProgressList() {
        return new TaskList();
    }

    @Bean(name = "doneList")
    public TaskList addDoneList() {
        return new TaskList();
    }

}

