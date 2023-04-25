package com.sparta.badgerBytes.webTesting.cucumber.stepdefs;

import com.sparta.badgerBytes.webTesting.pom.pages.ProductDetails;
import com.sparta.badgerBytes.webTesting.pom.pages.Products;
import com.sparta.badgerBytes.webTesting.pom.pages.HomePage;
import com.sparta.badgerBytes.webTesting.pom.util.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsStepDefs {

  private static WebDriver driver;
  private static HomePage homePage;

  private static Products products;
  private ProductDetails productDetails;
  private static WebElement inputForm;

//  @Before
//  public void setup() {
//    driver = BackgroundStepdefs.getDriver();
//    driver.manage().window().maximize();
//    homePage = new HomePage(driver);
//  }

  @Given("I am on the Automation Exercise homepage")
  public void iAmOnTheAutomationExerciseHomepage() {
    driver = BackgroundStepdefs.getDriver();
    driver.manage().window().maximize();
    homePage = new HomePage(driver);
  }

  @When("I click on the Products button")
  public void iClickOnTheProductsButton() {
    products = homePage.goToProductsPage();
  }

  @Then("the products list is visible")
  public void theProductsListIsVisible() {
    Assertions.assertTrue(products.getProductsList());
  }

  @Given("I am on the Products page")
  public void iAmOnTheProductsPage() {
//    homePage = new HomePage(driver);
//    products = homePage.goToProductsPage();
    Assertions.assertEquals("https://automationexercise.com/products", products.getURL());
  }

  @When("I click on the view product button for the first product")
  public void iClickOnTheViewProductButtonForTheFirstProduct() {
    productDetails = products.goToProductDetails();
  }

  @Then("then I see a page with details about the product")
  public void thenISeeAPageWithDetailsAboutTheProduct() {
//    System.out.println(productDetails.productInfoDivDisplayed());
  }

  @When("I enter a product name and click search button")
  public void iEnterAProductNameAndClickSearchButton() {
  }

  @Then("the text SEARCHED PRODUCTS is visible")
  public void theTextSEARCHEDPRODUCTSIsVisible() {
  }

  @And("all products related to search are visible")
  public void allProductsRelatedToSearchAreVisible() {
  }
}
