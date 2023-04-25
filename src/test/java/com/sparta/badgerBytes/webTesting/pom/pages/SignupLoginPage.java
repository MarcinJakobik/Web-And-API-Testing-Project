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

    public String findSignUpForm() {
        WebElement element = driver.findElement(By.cssSelector(".signup-form h2"));
        return element.getText();
    }
    public void enterName() {
        driver.findElement(By.name("name")).click();
        driver.findElement(By.name("name")).sendKeys("Reg");
    }
    public void enterEmail() {
        driver.findElement(By.cssSelector(".signup-form [name = 'email']")).click();
        driver.findElement(By.cssSelector(".signup-form [name = 'email']")).sendKeys("RHoward@spartaglobal.com");
    }
    public void submitSignup() {
        driver.findElement(By.cssSelector(".signup-form button")).click();
    }
    public String findErrorMessage() {
        return driver.findElement(By.cssSelector(".signup-form p")).getText();
    }
    private void goToSignupPage(){driver.get("https://automationexercise.com/login");}

    public void createAccount(String userName, String email){

        WebElement element = driver.findElement(By.name("name"));
        element.sendKeys(userName);
        element = driver.findElement(By.cssSelector("input[data-qa='signup-email']"));
        element.sendKeys(email);

        //maybe need timeout
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        driver.findElement(By.cssSelector("button[data-qa='signup-button']")).click();



        //return new SignUp(driver);
    }

    public void putInAccountDetails(String firstName, String lastName,String password, String company, String address, String state, String zipcode, String mobile_number, String city){

        WebElement element;


        element = driver.findElement(By.name("first_name"));
        element.sendKeys(firstName);

        element = driver.findElement(By.name("password"));
        element.sendKeys(password);

        element = driver.findElement(By.name("last_name"));
        element.sendKeys(lastName);

        element = driver.findElement(By.name("company"));
        element.sendKeys(company);

        element = driver.findElement(By.name("address1"));
        element.sendKeys(address);

        element = driver.findElement(By.name("state"));
        element.sendKeys(state);

        element = driver.findElement(By.name("zipcode"));
        element.sendKeys(zipcode);

        element = driver.findElement(By.name("mobile_number"));
        element.sendKeys(mobile_number);

        element = driver.findElement(By.name("city"));
        element.sendKeys(city);

        driver.findElement(By.cssSelector("button[data-qa='create-account']")).click();

        driver.findElement(By.cssSelector("a[data-qa='continue-button']")).click();

        //return new HomePage(driver);

    }
}
