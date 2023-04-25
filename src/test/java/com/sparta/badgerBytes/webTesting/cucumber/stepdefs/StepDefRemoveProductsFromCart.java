package com.sparta.badgerBytes.webTesting.cucumber.stepdefs;

import com.sparta.badgerBytes.webTesting.pom.pages.Cart;
import com.sparta.badgerBytes.webTesting.pom.pages.Checkout;
import com.sparta.badgerBytes.webTesting.pom.pages.HomePage;
import com.sparta.badgerBytes.webTesting.pom.pages.SignupLogin;
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

    private static WebDriver webDriver;

    private static final String DRIVER_LOCATION = "src/test/resources/chromedriver.exe";

    private HomePage homePage;

    private Cart cart;

    private Checkout checkout;

    private SignupLogin signupLogin;


    @Before
    public static void setup(){

        service = WebAutomationUtil.getChromeDriverService(DRIVER_LOCATION);

        webDriver = DriverFactory.getDriver();



    }

    @After
    public static void tearDownAll(){
        webDriver.close();
        webDriver.quit();
        service.stop();
    }


    @Given("I launch the browser")
    public void iLaunchWebsite() {
        webDriver = DriverFactory.getDriver();
    }

    @When("I navigate to the Homepage")
    public void iNavigateToTheUrlHttpAutomationexerciseCom() {
        homePage = new HomePage(webDriver);
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
        cart = homePage.goToCartPage();

    }

    @Then("the cart page is displayed successfully")
    public void theCartPageIsDisplayedSuccessfully() {
        Assert.assertEquals("https://automationexercise.com/view_cart",cart.getUrl());
    }

    @When("I click the X button corresponding to a particular product")
    public void iClickTheXButtonCorrespondingToAParticularProduct() {
     cart.deleteItemFromCart();

    }

    @Then("the product is removed from the cart")
    public void theProductIsRemovedFromTheCart() {
        Assert.assertEquals("Cart is empty!", cart.checkCartIsEmpty());

    }
}
