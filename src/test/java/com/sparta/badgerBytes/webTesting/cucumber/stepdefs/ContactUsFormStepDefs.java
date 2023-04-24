package com.sparta.badgerBytes.webTesting.cucumber.stepdefs;

import com.sparta.badgerBytes.webTesting.pom.pages.ContactUsPage;
import com.sparta.badgerBytes.webTesting.pom.pages.HomePage;
import com.sparta.badgerBytes.webTesting.pom.util.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class ContactUsFormStepDefs {

    private static WebDriver driver;
    private static HomePage homePage;
    private static ContactUsPage contactUsPage;

    @Before
    public void setup() {
        homePage = new HomePage(driver);
        driver = BackgroundStepdefs.getDriver();
    }
    @When("I click on the Contact Us link")
    public void iClickOnTheContactUsLink() {
        contactUsPage = homePage.goToContactUsPage();
    }

    @Then("I will go to the Contact Us page")
    public void iWillGoToTheContactUsPage() {

    }

    @And("I will see the Contact Us Form")
    public void iWillSeeTheContactUsForm() {

    }

    @And("I click the Submit button")
    public void iClickTheSubmitButton() {

    }

    @And("I click the OK button")
    public void iClickTheOKButton() {

    }

    @Then("I will see the Success message")
    public void iWillSeeTheSuccessMessage() {

    }

    @And("I click on the Home Page link")
    public void iClickOnTheHomePageLink() {

    }

    @Then("I will see the Home Page")
    public void iWillSeeTheHomePage() {

    }

    @And("I enter the contact form details")
    public void iEnterTheContactFormDetails() {

    }
}
