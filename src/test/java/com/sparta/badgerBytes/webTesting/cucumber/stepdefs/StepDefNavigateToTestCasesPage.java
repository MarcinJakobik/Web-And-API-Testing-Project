package com.sparta.badgerBytes.webTesting.cucumber.stepdefs;

import com.sparta.badgerBytes.webTesting.pom.pages.HomePage;
import com.sparta.badgerBytes.webTesting.pom.pages.TestCasesPage;
import com.sparta.badgerBytes.webTesting.pom.util.DriverFactory;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefNavigateToTestCasesPage {
    private static WebDriver webDriver;
    private static HomePage homePage;

    private static TestCasesPage testCasesPage;

    @Given("I am on the homepage")
    public void iAmOnTheHomepage() {
        webDriver = BackgroundStepdefs.getDriver();
        homePage = new HomePage(webDriver);
    }

    @When("I click the Test Cases button")
    public void iClickTheTestCasesButton() {
        testCasesPage = homePage.goToTestCasesPage();
    }

    @Then("I should be directed to the test_cases page")
    public void iShouldBeDirectedToTheTest_casesPage() {
        assertEquals("https://automationexercise.com/test_cases", testCasesPage.getUrl());
        webDriver.close();
        webDriver.quit();
    }


}
