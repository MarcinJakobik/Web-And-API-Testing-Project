package com.sparta.badgerBytes.webTesting.cucumber.stepdefs;

import com.sparta.badgerBytes.webTesting.pom.pages.BrandProductPage;
import com.sparta.badgerBytes.webTesting.pom.pages.HomePage;
import com.sparta.badgerBytes.webTesting.pom.util.DriverFactory;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BrandNavigationStepDef {
    HomePage homePage;
    BrandProductPage brandProductPage;
    private static WebDriver driver = DriverFactory.getDriver();

    @Given("I am on the home page")
    public void iAmOnTheHomePage() {
        homePage = new HomePage(driver);
    }

    @When("I click on the KOOKIE KIDS button")
    public void iClickOnTheKOOKIEKIDSButton() {
        brandProductPage = homePage.goToBrandPage("Kookie Kids");
    }

    @Then("I should be directed to the Kookie Kids product page")
    public void iShouldBeDirectedToTheKookieKidsProductPage() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
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
        driver = DriverFactory.getDriver();
        homePage = new HomePage(driver);
        homePage.turnOffAd();
        brandProductPage = homePage.goToBrandPage("Kookie Kids");
    }

    @When("I click on the BABYHUG button")
    public void iClickOnTheBABYHUGButton() {
        brandProductPage = brandProductPage.goToBrandPage("BABYHUG");
    }

    @Then("I should be directed to the Babyhug products page")
    public void iShouldBeDirectedToTheBabyhugProductsPage() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        assertEquals("https://automationexercise.com/brand_products/Babyhug", brandProductPage.getUrl());
    }

    @And("I should see all of the Babyhug products")
    public void iShouldSeeAllOfTheBabyhugProducts() {
        assertEquals("BRAND - BABYHUG PRODUCTS", brandProductPage.getBrandProductListTitle());
        assertEquals(brandProductPage.getExpectedBrandProductsCount(), brandProductPage.getBrandProductsCount());
    }
}