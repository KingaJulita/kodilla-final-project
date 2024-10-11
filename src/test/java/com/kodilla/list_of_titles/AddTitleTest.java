package com.kodilla.list_of_titles;

import com.kodilla.config.WebDriverConfig;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddTitleTest {
    private WebDriver driver;

    @Test
    public void testAddNewTitle() throws InterruptedException {
        driver = WebDriverConfig.initDriver();
        driver.get("https://ta-bookrental-fe.onrender.com/login");

        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement loginInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("login")));
        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
        WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-btn")));

        loginInput.sendKeys("kinga@example.com");
        passwordInput.sendKeys("password");
        loginButton.click();

        wait.until(ExpectedConditions.urlToBe("https://ta-bookrental-fe.onrender.com/"));


        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("lds-ripple")));

        Thread.sleep(2000);
        WebElement addTitleButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add-title-button")));


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", addTitleButton);

        Thread.sleep(2000);

        WebElement addNewTitleCard = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='sub-title' and text()='Add title']")));
        assertTrue(addNewTitleCard.isDisplayed(), "Karta dodawania tytułu jest widoczna.");



        WebElement titleInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("title")));
        WebElement authorInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("author")));
        WebElement yearInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("year")));

        titleInput.sendKeys("Przykładowy Tytuł");
        authorInput.sendKeys("Autor Przykładowy");
        yearInput.sendKeys("2024");


        WebElement submitButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("submit-button")));
        js.executeScript("arguments[0].click();", submitButton);


        Thread.sleep(2000);


        driver.quit();
    }
}
