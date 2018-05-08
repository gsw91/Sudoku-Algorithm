package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {

    private static final String XPATH_DAYOFBIRTH = "//div[contains(@class, \"5dbb\")]/div/span/span/select[1]";
    private static final String XPATH_MONTHOFBIRTH = "//div[contains(@class, \"5dbb\")]/div/span/span/select[2]";
    private static final String XPATH_YEAROFBIRTH = "//div[contains(@class, \"5dbb\")]/div/span/span/select[3]";
    private static final String XPATH_SELECTMAN = "//div[contains(@class, \"5wa2 _5dbb\")]/span/span[2]/input";

    public static void main (String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com");

        WebElement dayOfBirth = driver.findElement(By.xpath(XPATH_DAYOFBIRTH));
        dayOfBirth.sendKeys("21");

        WebElement monthOfBirth = driver.findElement(By.xpath(XPATH_MONTHOFBIRTH));
        Select selectMonth = new Select(monthOfBirth);
        selectMonth.selectByValue("4");

        WebElement yearOfBirth = driver.findElement(By.xpath(XPATH_YEAROFBIRTH));
        Select selectYear = new Select(yearOfBirth);
        selectYear.selectByValue("1991");

        WebElement selectSex = driver.findElement(By.xpath(XPATH_SELECTMAN));
        selectSex.click();
    }
}
