package com.kodilla.list_of_copies;

import com.kodilla.config.WebDriverConfig;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShowCopiesTest {
    private WebDriver driver;

    @Test
    public void testShowCopiesPageNavigation() throws InterruptedException {
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

        WebElement listOfCopiesHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(), 'List of copies')]")));
        assertTrue(listOfCopiesHeader.isDisplayed(), "List of copies page is not displayed.");

        driver.quit();
    }
}
