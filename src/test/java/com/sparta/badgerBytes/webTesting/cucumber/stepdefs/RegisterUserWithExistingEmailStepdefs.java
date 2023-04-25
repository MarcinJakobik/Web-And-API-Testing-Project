package com.sparta.badgerBytes.webTesting.cucumber.stepdefs;

import com.sparta.badgerBytes.webTesting.pom.pages.HomePage;
import com.sparta.badgerBytes.webTesting.pom.pages.SignupLoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegisterUserWithExistingEmailStepdefs {

    private static WebDriver driver = BackgroundStepdefs.getDriver();
    private static HomePage homePage;
    private static SignupLoginPage loginPage;

    @When("I click on the Signup And Login button")
    public void iClickOnTheSignupAndLoginButton() {
        driver = BackgroundStepdefs.getDriver();
        homePage = new HomePage(driver);
        loginPage = homePage.goToLoginPage();
    }
    @Then("I will go to the Login page")
    public void iWillGoToTheLoginPage() {
        loginPage = homePage.goToLoginPage();
        assertEquals("https://automationexercise.com/login", loginPage.getUrl());
    }
    @And("I will see the signup Form")
    public void iWillSeeTheSignupForm() {
        assertEquals("New User Signup!", loginPage.findSignUpForm());
    }

    @And("An account already exists")
    public void anAccountAlreadyExists() {
        loginPage.createAccount("Reg", "RHoward@SpartaGlobal.com");
        loginPage.putInAccountDetails("Reggie", "Howard", "password", "Sparta Global", "Some Address", "Montana", "59923", "456841531", "Libby");
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
        assertEquals("Email Address already exist!", loginPage.findErrorMessage());
    }
}