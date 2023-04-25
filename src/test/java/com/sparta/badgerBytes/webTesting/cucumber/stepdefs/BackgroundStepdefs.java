package com.sparta.badgerBytes.webTesting.cucumber.stepdefs;

import com.sparta.badgerBytes.webTesting.pom.util.DriverFactory;
import com.sparta.badgerBytes.webTesting.pom.pages.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BackgroundStepdefs {

  private static WebDriver driver;

  private static HomePage homePage;

  public static WebDriver getDriver() {
    if(driver==null) { return DriverFactory.getDriver(); }
    return driver;
  }

  @Before
  public void setup() {
    driver = DriverFactory.getDriver();
  }

  @Given("I am on the Automation Exercise Website")
  public void iAmOnTheAutomationExerciseWebsite() {
    homePage = new HomePage(driver);
    turnOffAd();
  }

  @When("I call the driver")
  public void iCallTheDriver() {
    homePage = new HomePage(driver);
    turnOffAd();
  }

  @Then("I will load the home page")
  public void iWillLoadTheHomePage() {
    assertEquals("https://automationexercise.com/", homePage.getUrl());
  }

  @After
  public void tearDown() {
    driver.quit();
  }
  public void turnOffAd() {
    if (driver.getCurrentUrl().contains("#")) {
      driver.manage().window().setSize(new Dimension(485, 800));
      try {
        Thread.sleep(3000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }
}