package com.kodilla.testing2.crudapp;

import com.kodilla.testing2.config.WebDriverConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class CrudAppTestSuite {

    private static final String BASE_URL = "https://gsw91.github.io/";
    private static final String TASK_NAME = "//form[contains(@class, \"row--add\")]/fieldset[1]/input";
    private static final String TASK_CONTENT = "//form[contains(@class, \"row--add\")]/fieldset[2]/textarea";
    private static final String ADD_TASK_BUTTON = "//form[contains(@class, \"row--add\")]/fieldset[3]/button";
    private WebDriver driver;
    private Random generator;

    @Before
    public void initTests() {
        driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get(BASE_URL);
        generator = new Random();
    }

    @Test
    public void shouldCreateTrelloCard() throws InterruptedException {
        //given
        String taskName = "Task number " + generator.nextInt(100000);
        String taskContent = taskName + " content";
        //when & then
        WebElement name = driver.findElement(By.xpath(TASK_NAME));
        name.sendKeys(taskName);

        WebElement content = driver.findElement(By.xpath(TASK_CONTENT));
        content.sendKeys(taskContent);

        WebElement buttonToClick = driver.findElement(By.xpath(ADD_TASK_BUTTON));
        buttonToClick.click();
        Thread.sleep(2000);
    }


    @After
    public void cleanUpAfterTest() {
        driver.close();
    }

}


