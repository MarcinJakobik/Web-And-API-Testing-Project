package com.sparta.badgerBytes.webTesting.cucumber.stepdefs.ContactUs;

import com.sparta.badgerBytes.webTesting.pom.pages.Cart;
import com.sparta.badgerBytes.webTesting.pom.pages.Checkout;
import com.sparta.badgerBytes.webTesting.pom.pages.HomePage;
import com.sparta.badgerBytes.webTesting.pom.pages.SignupLogin;
import com.sparta.badgerBytes.webTesting.pom.util.DriverFactory;
import com.sparta.badgerBytes.webTesting.pom.util.WebAutomationUtil;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.sparta.badgerBytes.webTesting.pom.util.DriverFactory.getDriver;
import static io.netty.handler.codec.rtsp.RtspHeaders.Values.URL;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContactUs {
    private static WebDriver driver;

    private static ChromeDriverService service;

    private HomePage homePage;
    private Cart cart;
    private Checkout checkout;
    private SignupLogin signupLogin;

    private static final String USERNAME = "hamza";




    @Given("I have launched the browser and navigated to the URL")
    public void iHaveLaunchedTheBrowserAndNavigatedToTheURLHttpAutomationexerciseCom() {
        driver = getDriver();
        homePage = new HomePage(driver);

    }
    @And("I click on the {string} button")
    public void iClickOnTheButton(String buttonName) {
        WebElement contactUsButton = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[8]/a"));
        contactUsButton.click();
    }

    @Then("I should see the {string} section")
    public void iShouldSeeTheGETINTOUCHSection(String sectionName) {
        By locator = By.xpath("//*[@id='contact-page']/div[2]/div[1]/div/h2");
        WebElement element = driver.findElement(locator);
        assertTrue(element.isDisplayed());
    }

    @And("I should be able to enter my name, email, subject, and message")
    public void iShouldBeAbleToEnterMyNameEmailSubjectAndMessage() {
        WebElement nameInput = driver.findElement(By.cssSelector("input[data-qa='name']"));
        nameInput.sendKeys("Hamza Kazi");
        WebElement emailInput = driver.findElement(By.cssSelector("input[data-qa='email']"));
        emailInput.sendKeys("hamza.kazi@test.com");
        WebElement subjectInput = driver.findElement(By.cssSelector("input[data-qa='subject']"));
        subjectInput.sendKeys("Test Subject");
        WebElement messageInput = driver.findElement(By.cssSelector("textarea[data-qa='message']"));
        messageInput.sendKeys("This is a test message.");

    }

    @And("I should be able to upload a file if necessary")
    public void iShouldBeAbleToUploadAFileIfNecessary() {

    }

    @Then("I should be able to click the Submit button")
    public void iShouldBeAbleToClickTheSubmitButton() {
        driver.findElement(By.name("submit")).click();
    }
    @And("I should see an OK button")
    public void iShouldSeeAnOKButton( ){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        assertTrue(alert.getText().contains("Press OK to proceed!"));
    }

    @When("I click on the OK button")
    public void iClickOnTheOKButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();

    }

    @Then("I should see the success message {string}")
    public void iShouldSeeTheSuccessMessageSuccessYourDetailsHaveBeenSubmittedSuccessfully(String successMessage) {
        By locator = By.xpath("//*[contains(text(), '" + successMessage + "')]");
        WebElement element = driver.findElement(locator);
        assertTrue(element.isDisplayed());
    }

    @And("I should be able to click the Home button")
    public void iShouldBeAbleToClickTheHomeButton() {
        WebElement homeButton = driver.findElement(By.xpath("//*[@id='header']/div/div/div/div[2]/div/ul/li[1]/a"));
        homeButton.click();
    }
    @And("I should be taken back to the home page successfully")
    public void iShouldBeTakenBackToTheHomePageSuccessfully() {
    }


}
