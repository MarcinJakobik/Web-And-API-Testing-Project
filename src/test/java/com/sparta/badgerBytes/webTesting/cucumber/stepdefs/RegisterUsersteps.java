package com.sparta.badgerBytes.webTesting.cucumber.stepdefs;
import com.sparta.badgerBytes.webTesting.pom.pages.HomePage;
import com.sparta.badgerBytes.webTesting.pom.util.WebAutomationUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegisterUsersteps {
    private static ChromeDriverService service;
    private static WebDriver driver;
    private static final String DRIVER_PATH = "src/test/java/resources/chromedriver.exe";

    @After
    public void tearDown() {
        driver.close();
        driver.quit();
        service.stop();
    }

    @Given("^I have launched the browser and navigated to the http://automationexercise.com")
    public void launchBrowserAndNavigateToURL() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\onurb\\code_batcave\\binary-search-tree\\Web-And-API-Testing-Project\\src\\test\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://automationexercise.com");
    }

    @Given("^I click on the 'Signup / Login' button$")
    public void clickSignupLoginButton() {
        WebElement signupLoginButton = driver.findElement(By.xpath("//button[contains(text(), 'Signup / Login')]"));
        signupLoginButton.click();
    }

    @Then("^I should see '(.*)' displayed on the page$")
    public void verifyTextDisplayed(String text) {
        WebElement element = driver.findElement(By.xpath("//*[contains(text(), '" + text + "')]"));
        assertTrue(element.isDisplayed());
    }

    @When("^I enter my name and email address$")
    public void enterNameAndEmailAddress() {
        WebElement nameInput = driver.findElement(By.id("nameInput"));
        nameInput.sendKeys("John Doe");
        WebElement emailInput = driver.findElement(By.id("emailInput"));
        emailInput.sendKeys("john.doe@example.com");
    }

    @When("^I click the 'Signup' button$")
    public void clickSignupButton() {
        WebElement signupButton = driver.findElement(By.id("signupButton"));
        signupButton.click();
    }

    @Then("^I should see 'ENTER ACCOUNT INFORMATION' displayed on the page$")
    public void verifyAccountInfoDisplayed() {
        WebElement element = driver.findElement(By.xpath("//*[contains(text(), 'ENTER ACCOUNT INFORMATION')]"));
        assertTrue(element.isDisplayed());
    }

    @When("^I fill in the required account information$")
    public void fillAccountInfo() {
        // Fill in the required account information here
    }

    @When("^I click the 'Create Account' button$")
    public void clickCreateAccountButton() {
        WebElement createAccountButton = driver.findElement(By.id("createAccountButton"));
        createAccountButton.click();
    }

    @Then("^I should see 'ACCOUNT CREATED!' displayed on the page$")
    public void verifyAccountCreated() {
        WebElement element = driver.findElement(By.xpath("//*[contains(text(), 'ACCOUNT CREATED!')]"));
        assertTrue(element.isDisplayed());
    }

    @And("I click the {string} button")
    public void iClickTheContinueButton() {
    }
}
