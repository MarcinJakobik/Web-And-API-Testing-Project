package com.sparta.badgerBytes.webTesting.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;

public class ContactUsPage {

    private final WebDriver driver;

    By homePageLink = new By.ByCssSelector("a[href='/']");

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
        WebElement element = driver.findElement(By.cssSelector(".contact-form h2"));
        return element.getText();
    }
    public void submitContactForm() {
        driver.findElement(By.name("submit")).click();
    }
    public void okContactForm() {
        driver.switchTo().alert().accept();
    }

    public String findSuccessMessage() {
        WebElement element = driver.findElement(By.cssSelector(".alert-success"));
        return element.getText();
    }

    public void inputContactUsFormMessage() {
        driver.findElement(By.cssSelector(".contact-form [name='name']")).sendKeys("Reg");
        driver.findElement(By.cssSelector(".contact-form [name='email']")).sendKeys("RHoward@SpartaGlobal.com");
        driver.findElement(By.cssSelector(".contact-form [name='subject']")).sendKeys("Test Subject");
        driver.findElement(By.cssSelector(".contact-form [name='message']")).sendKeys("Test Message With Lots Of Words");
        File archibald = new File("src/test/resources/features/Dz1lng.png");
        driver.findElement(By.cssSelector(".contact-form [type='file']")).sendKeys(archibald.getAbsolutePath());
    }
}