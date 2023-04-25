package com.sparta.badgerBytes.webTesting.cucumber.stepdefs.registerusersteps;

import com.github.javafaker.Faker;
import io.cucumber.java.AfterAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

import static com.sparta.badgerBytes.webTesting.pom.util.DriverFactory.getDriver;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegisterUsersteps {
    private String name;
    private Faker faker;

    @AfterAll
    void closeAll() {
        driver.quit();
        driver.close();
    }

    WebDriver driver;
    @Given("I have launched the browser and navigated to the URL {string}")
    public void iHaveLaunchedTheBrowserAndNavigatedToTheURLHttpAutomationexerciseCom(String URL) {
        driver = getDriver();

        driver.get(URL);
    }

//    @And("I close the add by clicking on the {string}")
//    public void iCloseTheAddByClickingOnTheCloseButton(String closeButton) throws InterruptedException {
//        try {
//            Thread.sleep(1000);
//
//            By elementLocator = By.className(closeButton);
//
//
//            if(driver.findElements(elementLocator).isEmpty()){
//                System.out.println("Add not found");
//
//            } else {
//                System.out.println("ADD FOUND");
//                WebElement closeAddButton = driver.findElement(By.className(closeButton));
//                closeAddButton.click();
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

    @And("I click on the Signup \\/ Login button")
    public void iClickOnTheSignupLoginButton() {
        WebElement signupLoginButton = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a"));
        signupLoginButton.click();
    }




    @Then("I should see {string} displayed on the page")
    public void iShouldSeeNewUserSignupDisplayedOnThePage(String newUser) {
        WebElement element = driver.findElement(By.xpath("//*[contains(text(), '" + newUser + "')]"));
        assertTrue(element.isDisplayed(), "Element with text '" + newUser + "' is not displayed on the page");
    }

    @When("I enter my name and email address")
    public void iEnterMyNameAndEmailAddress() {
        faker = new Faker();

        // create random name, password and email address
        name = faker.name().fullName();
        String email = faker.internet().emailAddress();


        // Find and input data into the web elements
        WebElement nameInput = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]"));
        WebElement emailInput = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]"));

        nameInput.sendKeys(name);
        emailInput.sendKeys(email);



    }

    @And("I click the {string} button")
    public void iClickTheSignupButton(String signUp) {
        WebElement submitButton = driver.findElement(By.xpath("//button[contains(text(), '" + signUp + "')]"));
        submitButton.click();
    }

    @Then("I should see {string} shown on the page")
    public void iShouldSeeEnterAccountInformation(String text) {
        WebElement element = driver.findElement(By.xpath("//*[contains(text(), '" + text + "')]"));
        assertTrue(element.isDisplayed(), "Element with text '" + text + "' is not displayed on the page");
    }

    @And("I fill in the required account information")
    public void iFillInTheRequiredAccountInformation() {
        // click Mr in input
        WebElement radioInput = driver.findElement(By.xpath("//*[@id=\"id_gender1\"]"));
        radioInput.click();

        // input random password
        Faker faker = new Faker();
        String password = faker.internet().password();

        WebElement passwordInput = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        passwordInput.sendKeys(password);

        // select random date
        WebElement dayInput = driver.findElement(By.xpath("//*[@id=\"days\"]"));
        dayInput.click();
        Select selectDay = new Select(dayInput);
        List<WebElement> dayOptions = selectDay.getOptions();

        Random randomDay = new Random();
        int dayIndex = randomDay.nextInt(dayOptions.size());
        selectDay.selectByIndex(dayIndex);

        // select random month
        WebElement monthInput = driver.findElement(By.xpath("//*[@id=\"months\"]"));
        monthInput.click();
        Select selectMonth = new Select(monthInput);
        List<WebElement> monthOptions = selectMonth.getOptions();

        Random randomMonth = new Random();
        int monthIndex = randomMonth.nextInt(monthOptions.size());
        selectMonth.selectByIndex(monthIndex);


        // select random year
        WebElement yearInput = driver.findElement(By.xpath("//*[@id=\"years\"]"));
        yearInput.click();
        Select selectYear = new Select(yearInput);
        List<WebElement> yearOptions = selectYear.getOptions();

        Random randomYear = new Random();
        int yearIndex = randomYear.nextInt(yearOptions.size());
        selectYear.selectByIndex(yearIndex);


        // first name and last name inputs
        String[] nameParts = name.split(" ");
        driver.findElement(By.xpath("//*[@id=\"first_name\"]")).sendKeys(nameParts[0]);

        driver.findElement(By.xpath("//*[@id=\"last_name\"]")).sendKeys(nameParts[1]);


        // random address inputs
        String streetAddress = faker.address().streetAddress();
        String city = faker.address().city();
        String state = faker.address().state();
        String zipCode = faker.address().zipCode();

        driver.findElement(By.xpath("//*[@id=\"address1\"]")).sendKeys(streetAddress);
//        driver.findElement(By.xpath(""))
    }

    @Then("I should see {string} on the page")
    public void iShouldSeeAccountCreatedOnThePage(String accountCreated) {
        WebElement element = driver.findElement(By.xpath("//*[contains(text(), '" + accountCreated + "')]"));
        assertTrue(element.isDisplayed(), "Element with text '" + accountCreated + "' is not displayed on the page");
    }


}



