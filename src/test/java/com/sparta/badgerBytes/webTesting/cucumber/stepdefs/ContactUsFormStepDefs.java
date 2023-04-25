package com.sparta.badgerBytes.webTesting.cucumber.stepdefs;

import com.sparta.badgerBytes.webTesting.pom.pages.ContactUsPage;
import com.sparta.badgerBytes.webTesting.pom.pages.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactUsFormStepDefs {

    private static WebDriver driver;
    private static HomePage homePage;
    private static ContactUsPage contactUsPage;

    @Before
    public void setup() {
        driver = BackgroundStepdefs.getDriver();
        homePage = new HomePage(driver);
    }

    @When("I click on the Contact Us link")
    public void iClickOnTheContactUsLink() {
        contactUsPage = homePage.goToContactUsPage();
    }
    @Then("I will go to the Contact Us page")
    public void iWillGoToTheContactUsPage() {
        assertEquals("https://automationexercise.com/contact_us", contactUsPage.getUrl());
    }
    @And("I will see the Contact Us Form")
    public void iWillSeeTheContactUsForm() {
        assertEquals("GET IN TOUCH", contactUsPage.findContactUsForm());
    }


    @And("I enter the contact form details")
    public void iEnterTheContactFormDetails() {
        contactUsPage.inputContactUsFormMessage(); // Incomplete
    }
    @And("I click the Submit button")
    public void iClickTheSubmitButton() {
        contactUsPage.submitContactForm();
    }
    @And("I click the OK button")
    public void iClickTheOKButton() {
        contactUsPage.okContactForm(); // Incomplete
    }
    @Then("I will see the Success message")
    public void iWillSeeTheSuccessMessage() {
        assertEquals("Success! Your details have been submitted successfully.", contactUsPage.findSuccessMessage());
    }


    @And("I click on the Home Page link")
    public void iClickOnTheHomePageLink() {
        contactUsPage.goToHomePage();
    }
    @Then("I will see the Home Page")
    public void iWillSeeTheHomePage() {
        assertEquals("https://automationexercise.com/", homePage.getUrl());
    }
}