package com.sparta.badgerBytes.webTesting.cucumber.stepdefs;

import com.sparta.badgerBytes.webTesting.pom.pages.CartPage;
import com.sparta.badgerBytes.webTesting.pom.pages.CheckoutPage;
import com.sparta.badgerBytes.webTesting.pom.pages.HomePage;
import com.sparta.badgerBytes.webTesting.pom.pages.SignupLoginPage;
import com.sparta.badgerBytes.webTesting.pom.util.DriverFactory;
import com.sparta.badgerBytes.webTesting.pom.util.WebAutomationUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class StepDefRemoveProductsFromCart {


    private static ChromeDriverService service;

    private static WebDriver driver;

    private static final String DRIVER_LOCATION = "src/test/resources/chromedriver.exe";

    private HomePage homePage;

    private CartPage cartPage;

    private CheckoutPage checkoutPage;


    @Before
    public void setup() {
        driver = BackgroundStepdefs.getDriver();
        homePage = new HomePage(driver);
    }

    @Given("I launch the browser")
    public void iLaunchWebsite() {
        driver = DriverFactory.getDriver();
    }

    @When("I navigate to the Homepage")
    public void iNavigateToTheUrlHttpAutomationexerciseCom() {
        homePage = new HomePage(driver);
    }

    @Then("the homepage is displayed successfully")
    public void theHomePageIsDisplayedSuccessfully() {
        Assert.assertEquals("https://automationexercise.com/",homePage.getUrl());
    }


    @And("I add products to cart")
    public void iAddProductsToCart() {
        homePage.addToCart();
    }

    @And("I click the cart button")
    public void iClickTheCartButton() {
        cartPage = homePage.goToCartPage();

    }

    @Then("the cart page is displayed successfully")
    public void theCartPageIsDisplayedSuccessfully() {
        Assert.assertEquals("https://automationexercise.com/view_cart", cartPage.getUrl());
    }

    @When("I click the X button corresponding to a particular product")
    public void iClickTheXButtonCorrespondingToAParticularProduct() {
     cartPage.deleteItemFromCart();

    }

    @Then("the product is removed from the cart")
    public void theProductIsRemovedFromTheCart() {
        Assert.assertEquals("Cart is empty!", cartPage.checkCartIsEmpty());

    }
}
