package com.kodilla.config;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class WebDriverConfig {
    public static WebDriver initDriver() {
        System.setProperty("webdriver.gecko.driver", "C:\\selenium-drivers\\Firefox\\geckodriver-v0.35.0-win32\\geckodriver.exe");
        return new FirefoxDriver();
    }
}
