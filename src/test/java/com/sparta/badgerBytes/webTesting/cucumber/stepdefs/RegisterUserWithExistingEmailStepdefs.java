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
    private static SignupLoginPage loginPage;

    @Before
    public void setup() {
        driver = DriverFactory.getDriver();
    }


    @Then("I will go to the Login page")
    public void iWillGoToTheLoginPage() {
        loginPage = homePage.goToLoginPage();
        assertEquals("https://automationexercise.com/login", loginPage.getUrl());
    }

    @And("I will see the signup Form")
    public void iWillSeeTheSignupForm() {
        WebElement element = driver.findElement(By.className("signup-form"));
        assertEquals("signup-form", element);
    }

    @When("I enter a Name")
    public void iEnterAName() {
        driver.findElement(By.name("name")).sendKeys("Reg");
    }

    @And("I enter an already registered email address")
    public void iEnterAnAlreadyRegisteredEmailAddress() {
        driver.findElement(By.name("email")).sendKeys("RHoward@spartaglobal.com");
    }

    @And("I click the signup button")
    public void iClickTheSignupButton() {
        driver.findElement(By.linkText("Signup")).click();
    }

    @Then("I will see the error message")
    public void iWillSeeTheErrorMessage() {
        assertEquals("Email Address already exists!", driver.findElement(By.cssSelector(".signup-form p")).getText());
    }

    @When("I click on the Signup And Login button")
    public void iClickOnTheSignupAndLoginButton() {
        System.out.println(driver.getCurrentUrl());
        driver.findElement(By.cssSelector("a[href='/login']")).click();
    }

    @Given("An account already exists")
    public void anAccountAlreadyExists() {

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}