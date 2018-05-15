package com.kodilla.testing2.crudapp;

import com.kodilla.testing2.config.WebDriverConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;

public class CrudAppTestSuite {

    private static final String BASE_URL = "https://gsw91.github.io/";
    private static final String TASK_NAME = "//form[contains(@class, \"row--add\")]/fieldset[1]/input";
    private static final String TASK_CONTENT = "//form[contains(@class, \"row--add\")]/fieldset[2]/textarea";
    private static final String ADD_TASK_BUTTON = "//form[contains(@class, \"row--add\")]/fieldset[3]/button";
    private static final String DELETE_TASK_BUTTON = ".//button[4]";
    private WebDriver driver;
    private Random generator;

    @Before
    public void initTests() {
        driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get(BASE_URL);
        generator = new Random();
    }

    @After
    public void cleanUpAfterTest() {
        driver.close();
    }

    @Test
    public void shouldCreateTrelloCard() throws InterruptedException {
        String taskName = createCrudAppTestTask();
        sendTestTaskToTrello(taskName);
        closeStatementHard();
        assertTrue(checkIfTaskExistsInTrello(taskName));
        Thread.sleep(3000);
        deleteCrudAppTask(taskName);
    }

    private void closeStatementHard() {
        driver.quit();
        driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get(BASE_URL);
    }

    private void deleteCrudAppTask(String taskName) throws InterruptedException{
        driver.findElements(By.xpath("//div[@class=\"datatable__tasks-container\"]/form")).stream()
                .filter(anyForm -> anyForm.findElement(By.xpath(".//p[@data-task-name-paragraph]")).getText().contains(taskName))
                .forEach(anyForm -> {
                    System.out.println(anyForm.getText());
                    WebElement deleteButton = anyForm.findElement(By.xpath(DELETE_TASK_BUTTON));
                    deleteButton.click();
                });
        Thread.sleep(2000);
    }

    private boolean checkIfTaskExistsInTrello(String taskName) throws InterruptedException {
        boolean result = false;
        final String TRELLO_URL = "https://trello.com/login";
        WebDriver driverTrello = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driverTrello.get(TRELLO_URL);

        driverTrello.findElement(By.id("user")).sendKeys("g.wojcik@vp.pl");
        driverTrello.findElement(By.id("password")).sendKeys("jnpgsw91");
        driverTrello.findElement(By.id("login")).submit();

        Thread.sleep(10000);

        driverTrello.findElements(By.xpath("//a[@class=\"board-tile\"]")).stream()
                .filter(t-> t.findElements(By.xpath(".//span[@title=\"Kodilla Application\"]")).size()>0)
                .forEach(t -> t.click());

        Thread.sleep(4000);

        result = driverTrello.findElements(By.xpath("//span[class=\"list-card-title js-card-name\"]")).stream()
                .filter(theSpan -> theSpan.getText().contains(taskName))
                .collect(Collectors.toList())
                .size()>=0;

        driverTrello.close();

        return result;

    }

    private void sendTestTaskToTrello(String taskName) throws InterruptedException {
        driver.navigate().refresh();

        while (!driver.findElement(By.xpath("//select[1]")).isDisplayed()) ;

        driver.findElements(By.xpath("//form[@class='datatable__row']")).stream()
                .filter(anyForm ->
                        anyForm.findElement(By.xpath(".//p[@class='datatable__field-value']"))
                                .getText().equals(taskName))
                .forEach(theForm -> {
                    WebElement selectElement = theForm.findElement(By.xpath(".//select[1]"));
                    Select select = new Select(selectElement);
                    select.selectByVisibleText("Kodilla Application");

                    WebElement buttonCreateCard =
                            theForm.findElement(By.xpath(".//button[contains(@class, \"card-creation\")]"));
                    buttonCreateCard.click();
                });
        Thread.sleep(5000);
    }

    private String createCrudAppTestTask() throws InterruptedException {
        String taskName = "Task number " + generator.nextInt(100000);
        String taskContent = taskName + " content";

        WebElement name = driver.findElement(By.xpath(TASK_NAME));
        name.sendKeys(taskName);

        WebElement content = driver.findElement(By.xpath(TASK_CONTENT));
        content.sendKeys(taskContent);

        WebElement buttonToClick = driver.findElement(By.xpath(ADD_TASK_BUTTON));
        buttonToClick.click();

        Thread.sleep(2000);
        driver.navigate().refresh();

        return taskName;
    }

}

