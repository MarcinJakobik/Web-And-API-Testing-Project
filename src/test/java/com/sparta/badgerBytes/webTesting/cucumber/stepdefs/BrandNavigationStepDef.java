package com.sparta.badgerBytes.webTesting.cucumber.stepdefs;

import com.sparta.badgerBytes.webTesting.pom.pages.BrandProductPage;
import com.sparta.badgerBytes.webTesting.pom.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BrandNavigationStepDef {
    HomePage homePage;
    BrandProductPage brandProductPage;
    WebDriver driver;
    @Given("I am on the home page")
    public void iAmOnTheHomePage() {
        driver = BackgroundStepdefs.getDriver();
        homePage = new HomePage(driver);
    }

    @When("I click on the KOOKIE KIDS button")
    public void iClickOnTheKOOKIEKIDSButton() {
        brandProductPage = homePage.goToBrandPage("KOOKIE KIDS");
    }

    @Then("I should be directed to the Kookie Kids product page")
    public void iShouldBeDirectedToTheKookieKidsProductPage() {
        assertEquals("https://automationexercise.com/brand_products/Kookie%20Kids", brandProductPage.getUrl());
    }

    @And("I should see all of the KOOKIE KIDS products")
    public void iShouldSeeAllOfTheKOOKIEKIDSProducts() {
        assertEquals("BRAND - KOOKIE KIDS PRODUCTS", brandProductPage.getBrandProductListTitle());
        assertEquals(brandProductPage.getExpectedBrandProductsCount(), brandProductPage.getBrandProductsCount());
    }

    @Given("I am on the Kookie Kids product page")
    public void iAmOnTheKookieKidsProductPage() {
        //new given makes me do the setup again :P
        homePage = new HomePage(driver);
        brandProductPage = homePage.goToBrandPage("KOOKIE KIDS");
    }

    @When("I click on the BABYHUG button")
    public void iClickOnTheBABYHUGButton() {
        brandProductPage = brandProductPage.goToBrandPage("BABYHUG");
    }

    @Then("I should be directed to the Babyhug products page")
    public void iShouldBeDirectedToTheBabyhugProductsPage() {
        assertEquals("https://automationexercise.com/brand_products/Babyhug", brandProductPage.getUrl());
    }

    @And("I should see all of the Babyhug products")
    public void iShouldSeeAllOfTheBabyhugProducts() {
        assertEquals("BRAND - BABYHUG PRODUCTS", brandProductPage.getBrandProductListTitle());
        assertEquals(brandProductPage.getExpectedBrandProductsCount(), brandProductPage.getBrandProductsCount());
    }



}
