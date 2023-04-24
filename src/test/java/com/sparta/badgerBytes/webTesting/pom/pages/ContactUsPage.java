package com.sparta.badgerBytes.webTesting.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactUsPage {

    private final WebDriver driver;

    By homePageLink = new By.ByLinkText("/");

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage goToHomePage() {
        driver.findElement(homePageLink).click();
        return new HomePage(driver);
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public String findContactUsForm() {
        WebElement element = driver.findElement(By.className("contact-form"));
        return element.getText();
    }
    public void submitContactForm() {
        driver.findElement(By.name("submit")).click();
    }
    public void okContactForm() {
        // How to select the out of window box?
    }

    public String findSuccessMessage() {
        WebElement element = driver.findElement(By.linkText("Success! Your details have been submitted successfully."));
        return element.getText();
    }

    public void inputContactUsFormMessage() {
        // Massive task, please no!
    }
}
