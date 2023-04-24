package com.sparta.badgerBytes.webTesting.pom.pages;

import com.sparta.badgerBytes.webTesting.pom.util.DriverFactory;
import io.cucumber.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SignupLoginPage {

    private final WebDriver driver;

    public SignupLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public WebElement findSignUpForm() {
        return driver.findElement(By.className("signup-form"));
    }
    public void enterName() {
        driver.findElement(By.name("name")).sendKeys("Reg");
    }
    public void enterEmail() {
        driver.findElement(By.name("email")).sendKeys("RHoward@spartaglobal.com");
    }
    public void submitSignup() {
        driver.findElement(By.linkText("Signup")).click();
    }
    public String findErrorMessage() {
        return driver.findElement(By.cssSelector(".signup-form p")).getText();
    }






    public SignupLoginPage createAccount() {
        driver.navigate().to("https://automationexercise.com/signup");
        driver.findElement(By.id("id_gender1")).click();
        driver.findElement(By.name("name")).sendKeys("Reg");
        driver.findElement(By.name("email")).sendKeys("RHoward@spartaGlobal.com");
        driver.findElement(By.name("password")).sendKeys("password");
        driver.findElement(By.name("days")).sendKeys(Keys.chord(Keys.NUMPAD2, Keys.NUMPAD4, Keys.ENTER));
        driver.findElement(By.name("months")).sendKeys("April");
        driver.findElement(By.name("years")).sendKeys("1995");
        driver.findElement(By.name("first_name")).sendKeys("Reggie");
        driver.findElement(By.name("last_name")).sendKeys("Howard");
        driver.findElement(By.name("address1")).sendKeys("Some Address");
        driver.findElement(By.name("country")).sendKeys("United States");
        driver.findElement(By.name("state")).sendKeys("Montana");
        driver.findElement(By.name("city")).sendKeys("Libby");
        driver.findElement(By.name("zipcode")).sendKeys("59923");
        driver.findElement(By.name("mobile_number")).sendKeys("456841531");
        driver.findElement(By.tagName("button")).click();
        checkAccountWasCreated();
        return new SignupLoginPage(driver);
    }

    public void checkAccountWasCreated() {
        assertEquals("https://automationexercise.com/account_created", driver.getCurrentUrl());
    }
}
