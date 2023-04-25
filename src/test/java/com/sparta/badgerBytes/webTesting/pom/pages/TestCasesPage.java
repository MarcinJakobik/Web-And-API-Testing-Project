package com.sparta.badgerBytes.webTesting.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCasesPage {
    private static WebDriver driver;
    public TestCasesPage(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public String getUrl(){
        return driver.getCurrentUrl();
    }
}
