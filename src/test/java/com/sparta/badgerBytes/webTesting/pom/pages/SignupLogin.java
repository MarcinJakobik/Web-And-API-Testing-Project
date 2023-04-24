package com.sparta.badgerBytes.webTesting.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignupLogin {

    private final WebDriver driver;

    public SignupLogin(WebDriver driver) {

        this.driver = driver;
        goToSignupPage();
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
