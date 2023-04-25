package com.sparta.badgerBytes.webTesting.cucumber.stepdefs;

import com.sparta.badgerBytes.webTesting.pom.pages.CartPage;
import com.sparta.badgerBytes.webTesting.pom.pages.HomePage;
import com.sparta.badgerBytes.webTesting.pom.pages.SuperFooterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartMailSubscriptionStepDefs {

  private static HomePage homePage;
  private static WebDriver driver = BackgroundStepdefs.getDriver();
  private static CartPage cartPage;
  private static WebElement footer;
  private static WebElement subscriptionHeading;
  private static WebElement inputForm;

  @Given("I am on the automation exercise website shopping cart")
  public void iAmOnTheAutomationExerciseWebsiteShoppingCart() {
    homePage = new HomePage(driver);
    cartPage = homePage.goToCartPage();
  }

  @When("I look at the shopping cart footer")
  public void iLookAtTheShoppingCartFooter() {
    footer = cartPage.getFooter();
  }

  @Then("I see the text SUBSCRIPTION in the shopping cart footer")
  public void iSeeTheTextSUBSCRIPTIONInTheShoppingCartFooter() {
    Assertions.assertEquals("SUBSCRIPTION", cartPage.getSubscriptionHeading().getText());
  }

  @When("I enter my email address in the mail subscription form in the shopping cart")
  public void iEnterMyEmailAddressInTheMailSubscriptionFormInTheShoppingCart() {
    inputForm = cartPage.getEmailInput();
    inputForm.sendKeys("name@website.com");
  }

  @And("I Click the arrow button in the email subscription form in the shopping cart")
  public void iClickTheArrowButtonInTheEmailSubscriptionFormInTheShoppingCart() {
    WebElement button = cartPage.getArrowButton();
    button.click();
  }

  @Then("the success message is visible in the email subscription form in the shopping cart")
  public void theSuccessMessageIsVisibleInTheEmailSubscriptionFormInTheShoppingCart() {
    Assertions.assertEquals("SUBSCRIPTION", cartPage.getSubscriptionHeading().getText());
  }
}
