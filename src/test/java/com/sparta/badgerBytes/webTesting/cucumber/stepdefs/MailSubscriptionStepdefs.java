package com.sparta.badgerBytes.webTesting.cucumber.stepdefs;

import com.sparta.badgerBytes.webTesting.pom.pages.Cart;
import com.sparta.badgerBytes.webTesting.pom.pages.HomePage;
import com.sparta.badgerBytes.webTesting.pom.util.WebAutomationUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

public class MailSubscriptionStepdefs {
    private static ChromeDriverService service;
    private static WebDriver driver;
    private static HomePage homePage;

    private static Cart cartPage;
    private static WebElement footer;
    private static WebElement subscriptionHeading;
    private static WebElement inputForm;
    private static final String DRIVER_PATH = "src/test/resources/chromedriver";
    @Before
    public void setup() {

        service = WebAutomationUtil.getChromeDriverService(DRIVER_PATH);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("headless");
        driver = new ChromeDriver(service, options);
        driver.manage().window().maximize();
    }
    @After
    public void tearDown() {
        driver.close();
        driver.quit();
        service.stop();
    }
    @Given("I am on the automation exercise website")
    public void iAmOnTheAutomationExerciseWebsite() {
        homePage = new HomePage(driver);
    }

    @When("I look down at the footer")
    public void iLookDownAtTheFooter() {
       footer = homePage.getFooter();
    }

    @Then("I see the text SUBSCRIPTION and an input form")
    public void iSeeTheText() {
        subscriptionHeading = homePage.getSubscriptionHeading();
        Assertions.assertEquals("SUBSCRIPTION", subscriptionHeading.getText());
    }

    @And("an input form")
    public void anInputForm() {
        inputForm = homePage.getEmailInput();
    }

    @When("I enter my email address")
    public void iEnterMyEmailAddress() {
        inputForm = homePage.getEmailInput();
        inputForm.sendKeys("name@website.com");
    }

    @And("I Click the arrow button")
    public void iClickTheArrowButton() {
        WebElement button = homePage.getArrowButton();
        button.click();
    }

    @Then("the success message is visible")
    public void the_success_message_is_visible() {
        Assertions.assertEquals("You have been successfully subscribed!", homePage.getSuccessMessage().getText());
    }

    @When("I click on the Cart button")
    public void iClickOnTheCartButton() {
        cartPage = homePage.goToCartPage();
    }

    @Then("I see the text SUBSCRIPTION")
    public void iSeeTheTextSUBSCRIPTION() {
        Assertions.assertEquals("SUBSCRIPTION", cartPage.getSubscriptionHeading().getText());
    }
}
