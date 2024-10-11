package com.kodilla.rentals;

import com.kodilla.config.WebDriverConfig;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class RentTest {
    private WebDriver driver;

    @Test
    public void testAddRental() throws InterruptedException {
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


        WebElement showCopiesButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("show-copies-btn")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", showCopiesButton);


        WebElement showHistoryButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("show-rents-btn")));
        js.executeScript("arguments[0].click();", showHistoryButton);


        WebElement rentThisCopyButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add-rent-button")));
        js.executeScript("arguments[0].click();", rentThisCopyButton);


        WebElement customerNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("customer-name")));
        customerNameInput.sendKeys("kinga@example.com");


        WebElement addCopyButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("submit-button")));
        js.executeScript("arguments[0].click();", addCopyButton);

        driver.quit();
    }
}
