package com.kodilla.login_registration;


import com.kodilla.config.WebDriverConfig;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPageTest {
    private WebDriver driver;

    @Test
    public void testDisplayLoginForm() {
        driver = WebDriverConfig.initDriver();
        driver.get("https://ta-bookrental-fe.onrender.com/login");

        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement loginInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("login")));
        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
        WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-btn")));

        assertTrue(loginInput.isDisplayed(), "Login input should be displayed");
        assertTrue(passwordInput.isDisplayed(), "Password input should be displayed");
        assertTrue(loginButton.isDisplayed(), "Login button should be displayed");

        driver.quit();
    }
}
