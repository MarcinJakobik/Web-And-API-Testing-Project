package com.sparta.badgerBytes.webTesting.cucumber.stepdefs;

import com.sparta.badgerBytes.webTesting.pom.pages.CartPage;
import com.sparta.badgerBytes.webTesting.pom.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomeMailSubscriptionStepDefs {

  private static WebDriver driver = BackgroundStepdefs.getDriver();
  private static HomePage homePage;
  private static CartPage cartPage;
  private static WebElement footer;
  private static WebElement subscriptionHeading;
  private static WebElement inputForm;

  @Given("I am on the automation exercise website")
  public void iAmOnTheAutomationExerciseWebsite() {
    driver = BackgroundStepdefs.getDriver();
    homePage = new HomePage(driver);
  }

  @When("I look at the home page footer")
  public void iLookAtTheHomePageFooter() {
    footer = homePage.getFooter();
  }

  @Then("I see the text SUBSCRIPTION and an input form")
  public void iSeeTheTextSUBSCRIPTIONAndAnInputForm() {
    subscriptionHeading = homePage.getSubscriptionHeading();
    Assertions.assertEquals("SUBSCRIPTION", subscriptionHeading.getText());
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
  public void theSuccessMessageIsVisible() {
    Assertions.assertEquals("You have been successfully subscribed!", homePage.getSuccessMessage().getText());

  }
}
