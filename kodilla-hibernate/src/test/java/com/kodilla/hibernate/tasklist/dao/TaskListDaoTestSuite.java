package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskListDaoTestSuite {

    @Autowired
    TaskListDao taskListDao;
    private final String DESCRIPTION = "Test";

    @Test
    public void testFindByListName() {

        //Given
        TaskList taskList = new TaskList("Testing List", DESCRIPTION);
        taskListDao.save(taskList);

        //When
        int id = taskList.getId();
        String listName = taskListDao.findOne(id).getListName();
        List<TaskList> readList = taskListDao.findByListName(listName);

        //Then
        Assert.assertEquals(1, readList.size());

        //CleanUp
        taskListDao.deleteAll();

    }
}
