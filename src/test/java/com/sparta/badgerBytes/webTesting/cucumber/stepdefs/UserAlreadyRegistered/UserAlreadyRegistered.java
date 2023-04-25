package com.sparta.badgerBytes.webTesting.cucumber.stepdefs.UserAlreadyRegistered;

import com.sparta.badgerBytes.webTesting.pom.pages.CartPage;
import com.sparta.badgerBytes.webTesting.pom.pages.CheckoutPage;
import com.sparta.badgerBytes.webTesting.pom.pages.HomePage;
import com.sparta.badgerBytes.webTesting.pom.pages.SignupLogin;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.sparta.badgerBytes.webTesting.pom.util.DriverFactory.getDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserAlreadyRegistered {
    private static WebDriver driver;

    private static ChromeDriverService service;

    private HomePage homePage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private SignupLogin signupLogin;

    private static final String USERNAME = "hamza";
    @Given("I have launched the browser and navigated to the URL")
    public void iHaveLaunchedTheBrowserAndNavigatedToTheURLHttpAutomationexerciseCom() {
        driver = getDriver();
        homePage = new HomePage(driver);
    }

    @And("I click on the {string} button")
    public void iClickOnTheSignupLoginButton(String buttonName) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        WebElement signupLoginButton = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a"));
        signupLoginButton.click();

    }

    @Then("I should see {string} displayed on the page")
    public void iShouldSeeNewUserSignupDisplayedOnThePage(String newUser) {
        By locator = By.xpath("//*[@id='form']/div/div/div[3]/div/h2");
        WebElement element = driver.findElement(locator);
        assertTrue(element.isDisplayed());
        assertEquals(newUser, element.getText());
    }

    @When("I enter my name and an already registered email address")
    public void iEnterMyNameAndAnAlreadyRegisteredEmailAddress() {
        WebElement nameInput = driver.findElement(By.name("name"));
        nameInput.sendKeys("Hamza Kazi");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-qa='signup-email']")));
        emailInput.sendKeys("hamza.kazi@test.com");
    }

    @And("I click the {string} button")
    public void iClickTheSignupButton(String buttonText) throws InterruptedException {
        WebElement signupButton = driver.findElement(By.xpath("//*[text()='" + buttonText + "']"));
        signupButton.click();
        Thread.sleep(2500);
    }

    @Then("I should see the error message {string} displayed on the page")
    public void iShouldSeeTheErrorMessageEmailAddressAlreadyExistDisplayedOnThePage(String errorMessage) {
        assertTrue(driver.findElement(By.xpath("//*[contains(text(), '" + errorMessage + "')]")).isDisplayed());
    }
}
