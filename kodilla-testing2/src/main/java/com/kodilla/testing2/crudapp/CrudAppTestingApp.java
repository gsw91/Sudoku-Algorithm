package com.kodilla.testing2.crudapp;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CrudAppTestingApp {
    public static final String XPATH_INPUT_NAME = "//html/body/main/section/form/fieldset/input";
    public static final String XPATH_INPUT_CONTENT = "//html/body/main/section/form/fieldset[2]/textarea";
    public static final String XPATH_WAITFOR = "//select[1]";
    public static final String XPATH_SELECT = "//div[contains(@class, \"tasks-container\")]/form/div/fieldset/select[1]";

    public static void main (String[] args) {
        WebDriver webDriver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        webDriver.get("https://gsw91.github.io/");

        WebElement fieldOne = webDriver.findElement(By.xpath(XPATH_INPUT_NAME));
        fieldOne.sendKeys("New robotic task");

        WebElement fieldTwo = webDriver.findElement(By.xpath(XPATH_INPUT_CONTENT));
        fieldTwo.sendKeys("New robotic content");

        while(!webDriver.findElement(By.xpath(XPATH_WAITFOR)).isDisplayed());

        WebElement selectCombo = webDriver.findElement(By.xpath(XPATH_SELECT));
        Select selectBoard = new Select(selectCombo);
        selectBoard.selectByIndex(1);
    }
}
