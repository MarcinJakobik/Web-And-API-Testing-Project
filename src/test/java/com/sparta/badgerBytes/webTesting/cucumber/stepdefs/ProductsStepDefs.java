package com.sparta.badgerBytes.webTesting.cucumber.stepdefs;

import com.sparta.badgerBytes.webTesting.pom.pages.Products;
import com.sparta.badgerBytes.webTesting.pom.pages.HomePage;
import com.sparta.badgerBytes.webTesting.pom.util.DriverFactory;
import com.sparta.badgerBytes.webTesting.pom.util.WebAutomationUtil;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
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

public class ProductsStepDefs {

  private static ChromeDriverService service;
  private static WebDriver driver;
  private static HomePage homePage;

  private static Products products;
  private static WebElement inputForm;
  private static final String DRIVER_PATH = "src/test/resources/chromedriver";
  @Before
  public void setup() {

//    service = WebAutomationUtil.getChromeDriverService(DRIVER_PATH);
//    ChromeOptions options = new ChromeOptions();
//    options.addArguments("--remote-allow-origins=*");
//    options.addArguments("headless");
//    driver = new ChromeDriver(service, options);
    driver = DriverFactory.getDriver();
    driver.manage().window().maximize();
  }

  @After
  public static void tearDown() {
//    driver.close();
//    driver.quit();
//    service.stop();
    driver.quit();
  }

  @Given("I am on the Automation Exercise homepage")
  public void iAmOnTheAutomationExerciseHomepage() {
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
    Assertions.assertEquals("https://automationexercise.com/products", products.getURL());
  }

  @When("I click on the view product button for the first product")
  public void iClickOnTheViewProductButtonForTheFirstProduct() {
  }

  @Then("then I see a page with details about the product")
  public void thenISeeAPageWithDetailsAboutTheProduct() {
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
