package com.sparta.badgerBytes.webTesting.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Footer {
    protected final WebDriver driver;
    By subscriptionText = By.cssSelector("#footer > div.footer-widget > div > div > div.col-sm-3.col-sm-offset-1 > div > h2");
    By footer = By.id("footer");
    By emailInput = By.id("susbscribe_email"); // sic, should be subscribe_email but there is a typo on the page
    By arrowButton = By.id("subscribe");
    By successMessage = By.id("success-subscribe");

    public Footer(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public WebElement getSubscriptionHeading() {
        return driver.findElement(subscriptionText);
    }

    public WebElement getFooter() {
        return driver.findElement(footer);
    }

    public WebElement getEmailInput() {
        return driver.findElement(emailInput);
    }

    public WebElement getArrowButton() {
        return driver.findElement(arrowButton);
    }

    public WebElement getSuccessMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        return driver.findElement(successMessage);
    }
}
