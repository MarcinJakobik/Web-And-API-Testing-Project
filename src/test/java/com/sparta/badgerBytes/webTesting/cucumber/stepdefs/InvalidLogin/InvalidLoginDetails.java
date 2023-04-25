package com.sparta.badgerBytes.webTesting.cucumber.stepdefs.InvalidLogin;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static com.sparta.badgerBytes.webTesting.pom.util.DriverFactory.getDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InvalidLoginDetails {
    WebDriver driver;
//    @AfterAll
//    public void tearDown() {
//        driver.close();
//        driver.quit();
//        service.stop();
//    }


    @Given("I have launched the browser and navigated to the URL {string}")
    public void iHaveLaunchedTheBrowserAndNavigatedToTheURLHttpAutomationexerciseCom(String URL) {
        driver = getDriver();
        driver.get(URL);
    }
    @When("I click on the {string} button")
    public void iClickOnTheSignupLoginButton(String buttonName) {
        driver.findElement(By.xpath("//*[contains(text(),'" + buttonName + "')]")).click();
    }

    @Then("I should see {string} displayed on the page")
    public void iShouldSeeLoginToYourAccountDisplayedOnThePage(String loginToYourAccount) {
        driver.findElement(By.xpath("//*[contains(text(),'" + loginToYourAccount + "')]")).click();
        assertEquals("https://automationexercise.com/login", driver.getCurrentUrl());
    }

    @When("I enter an incorrect email address and password")
    public void iEnterAnIncorrectEmailAddressAndPassword() {
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]")).sendKeys("incorrect_email@example.com");
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]")).sendKeys("incorrect_password");

    }

    @And("I click the {string} button")
    public void iClickTheLoginButton(String loginButton) {
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div[1]/form/button")).click();
    }

    @Then("I should see the error message {string} displayed on the page")
    public void iShouldSeeTheErrorMessageYourEmailOrPasswordIsIncorrectDisplayedOnThePage(String errorMessage) {
        driver.findElement(By.xpath("//*[contains(text(),'" + errorMessage + "')]")).click();
    }



}
