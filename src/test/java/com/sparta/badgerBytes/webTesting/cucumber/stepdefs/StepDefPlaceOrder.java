package com.sparta.badgerBytes.webTesting.cucumber.stepdefs;

import com.sparta.badgerBytes.webTesting.pom.pages.*;
import com.sparta.badgerBytes.webTesting.pom.util.DriverFactory;
import com.sparta.badgerBytes.webTesting.pom.util.WebAutomationUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Nested;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

public class StepDefPlaceOrder {

    private static ChromeDriverService service;

    private static WebDriver webDriver;

    private static final String DRIVER_LOCATION = "src/test/resources/chromedriver.exe";

    private HomePage homePage;

    private Cart cart;

    private Checkout checkout;

    private SignupLogin signupLogin;


    private static final String USERNAME = "liamm";

    private static boolean confirmedPayment;
    @Before
    public static void setup(){

        service = WebAutomationUtil.getChromeDriverService(DRIVER_LOCATION);

        webDriver = DriverFactory.getDriver();



    }

    @After
    public static void tearDownAll(){
//        webDriver.close();
//        webDriver.quit();
//       service.stop();
    }


    @Given("I am on the Homepage")
    public void iAmOnTheHomepage() { homePage = new HomePage(webDriver);}

    @When("I add a product to the cart")
    public void iAddAProductToTheCart() {
        homePage.addToCart();

    }

    @Then("I will go to the cart")
    public void iWillGoToTheCart() {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        homePage.clickContinueShopping();
        cart = homePage.goToCartPage();
        Assert.assertEquals("https://automationexercise.com/view_cart", cart.getUrl() );


    }

    @And("see that the product has been added to the cart")
    public void seeThatTheProductHasBeenAddedToTheCart() {



        Assert.assertEquals(true,cart.checkByClass("product_image"));
    }

    @Given("I am on the cart page")
    public void iAmOnTheCartPage() {
        iAmOnTheHomepage();
        iAddAProductToTheCart();
        iWillGoToTheCart();
    }

    @When("I click the proceed to checkout button")
    public void iClickTheProceedToCheckoutButton() {

        signupLogin = cart.proceedToCheckoutRegister();
    }

    @And("Click on the create account button")
    public void clickOnTheCreateAccountButton() {
        signupLogin.createAccount(USERNAME, "Marcien@example.com");
    }

    @Then("I will put in my Name andEmail Address")
    public void iWillPutInMyNameAndEmailAddress() {
       signupLogin.putInAccountDetails("Example","Example","Example","Example",
                "Example","Example","Example","Example","Example");
    }

    @And("I will create a account")
    public void iWillCreateAAccount() {

        Assert.assertTrue(homePage.checkIfLoggedInAsUser(USERNAME));

    }


    @And("I have verified I am logged in")
    public void iHaveVerifiedIAmLoggedIn() {

        homePage.checkIfLoggedInAsUser(USERNAME);
    }

    @When("I click on the cart")
    public void iClickOnTheCart() {
        homePage.goToCartPage();
    }

    @And("have items in the cart")
    public void haveItemsInTheCart() {
        Assert.assertEquals(true,cart.checkByClass("product_image"));
    }

    @Then("click proceed to checkout button")
    public void clickProceedToCheckoutButton() {
        checkout = cart.proccedToCheckout();
    }

    @And("I have entered my payment details")
    public void iHaveEnteredMyDetails() {
        //procceed(place order)
        //put in cary details
        checkout.placeOrderButton();
        confirmedPayment= checkout.putInPaymentDetailsAndConfirmOrder("liam","3243","434","3443","43");

    }

    @And("I verified the order was a success")
    public void iVerifiedTheOrderWasASuccess() {
        Assert.assertTrue( confirmedPayment);
    }

    @When("I click the delete account button")
    public void iClickTheDeleteAccountButton() {
        homePage.deleteAccount();
    }

    @And("clicked the verify account deletion button")
    public void clickedTheVerifyAccountDeletionButton() {
        //done in previous step
    }

    @Then("my account should be deleted")
    public void myAccountShouldBeDeleted() {
        //account deleted
    }



}
