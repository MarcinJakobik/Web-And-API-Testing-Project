package com.sparta.badgerBytes.webTesting.cucumber.stepdefs;

import com.sparta.badgerBytes.webTesting.pom.pages.HomePage;
import com.sparta.badgerBytes.webTesting.pom.pages.SignupLoginPage;
import com.sparta.badgerBytes.webTesting.pom.util.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegisterUserWithExistingEmailStepdefs {

    private static WebDriver driver;
    private static HomePage homePage;
    private static WebElement element;
    private static SignupLoginPage loginPage;

    @Before
    public void setup() {
        homePage = new HomePage(driver);
        driver = BackgroundStepdefs.getDriver();
    }

    @Then("I will go to the Login page")
    public void iWillGoToTheLoginPage() {
        loginPage = homePage.goToLoginPage();
        assertEquals("https://automationexercise.com/login", loginPage.getUrl());
    }
    @And("I will see the signup Form")
    public void iWillSeeTheSignupForm() {
        assertEquals("signup-form", loginPage.findSignUpForm());
    }


    @When("I enter a Name")
    public void iEnterAName() {
        loginPage.enterName();
    }
    @And("I enter an already registered email address")
    public void iEnterAnAlreadyRegisteredEmailAddress() {
        loginPage.enterEmail();
    }
    @And("I click the signup button")
    public void iClickTheSignupButton() {
        loginPage.submitSignup();
    }

    @Then("I will see the error message")
    public void iWillSeeTheErrorMessage() {
        assertEquals("Email Address already exists!", loginPage.findErrorMessage());
    }


    @When("I click on the Signup And Login button")
    public void iClickOnTheSignupAndLoginButton() {
        loginPage = homePage.goToLoginPage();
    }

    @Given("An account already exists")
    public void anAccountAlreadyExists() {
        // This is related to TC 1, connect when uploaded.
    }
}