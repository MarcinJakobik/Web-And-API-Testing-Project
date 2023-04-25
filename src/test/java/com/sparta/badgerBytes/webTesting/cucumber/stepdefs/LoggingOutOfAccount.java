package com.sparta.badgerBytes.webTesting.cucumber.stepdefs;

import com.sparta.badgerBytes.webTesting.pom.pages.HomePage;
import com.sparta.badgerBytes.webTesting.pom.pages.SignupLogin;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.sparta.badgerBytes.webTesting.pom.util.DriverFactory.getDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoggingOutOfAccount {
    private static HomePage homePage;
    private static SignupLogin signupLogin;
    private static WebDriver driver;

    @Given("I have launched the browser and navigated to the correct URL")
    public void iHaveLaunchedTheBrowserAndNavigatedToTheCorrectURL() {
        driver = getDriver();
        homePage = new HomePage(driver);
    }

    @When("I click on the correct Login button")
    public void iClickOnTheCorrectLoginButton() {
        signupLogin = homePage.goToSignupLogin();
    }

    @Then("I should see Login to your account displayed on the page")
    public void iShouldSeeLoginToYourAccountDisplayedOnThePage() {
        signupLogin.isTheLoginToYourAccountMessageDisplayed();
        assertEquals("https://automationexercise.com/login", driver.getCurrentUrl());
    }

    @When("I enter my correct email address and password")
    public void iEnterMyCorrectEmailAddressAndPassword() {
        signupLogin.enteringIncorrectEmailAndPassword();
    }

    @And("I click the Login button")
    public void iClickTheLoginButton() {
        signupLogin.clickingActualLoginButton();
    }

    @Then("I should see Logged in as username displayed on the page")
    public void iShouldSeeLoggedInAsUsernameDisplayedOnThePage() {
        signupLogin.checkThatTheUsernameOnTheTopIsCorrect();
    }

    @When("I click on the Logout button")
    public void iClickOnTheLogoutButton() {
        signupLogin.clickTheLogoutButton();
    }

    @Then("I should be navigated to the login page")
    public void iShouldBeNavigatedToTheLoginPage() {
        assertEquals("https://automationexercise.com/login", driver.getCurrentUrl());
    }
}
