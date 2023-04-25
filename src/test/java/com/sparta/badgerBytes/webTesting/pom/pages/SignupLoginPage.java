package com.sparta.badgerBytes.webTesting.pom.pages;

import com.sparta.badgerBytes.webTesting.pom.util.DriverFactory;
import io.cucumber.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SignupLoginPage {

    private final WebDriver driver;

    public SignupLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public String findSignUpForm() {
        WebElement element = driver.findElement(By.cssSelector(".signup-form h2"));
        return element.getText();
    }

    public void enterName() {
        driver.findElement(By.cssSelector(".signup-form [name = 'name']")).click();
        driver.findElement(By.cssSelector(".signup-form [name = 'name']")).sendKeys("Reg");
    }

    public void enterEmail() {
        driver.findElement(By.cssSelector(".signup-form [name = 'email']")).click();
        driver.findElement(By.cssSelector(".signup-form [name = 'email']")).sendKeys("RHoward@spartaglobal.com");
    }

    public void submitSignup() {
        driver.findElement(By.cssSelector(".signup-form button")).click();
    }

    public String findErrorMessage() {
        return driver.findElement(By.cssSelector(".signup-form p")).getText();
    }

    private void goToSignupPage() {
        driver.get("https://automationexercise.com/login");
    }

    public void login(String email, String password) {
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.cssSelector("button[data-qa='login-button']")).click();
    }

    public void createAccount(String userName, String email) {

        WebElement element = driver.findElement(By.name("name"));
        element.sendKeys(userName);
        element = driver.findElement(By.cssSelector("input[data-qa='signup-email']"));
        element.sendKeys(email);

        //maybe need timeout
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        driver.findElement(By.cssSelector("button[data-qa='signup-button']")).click();


        //return new SignUp(driver);
    }
    public void createAnAccount(String userName, String email) {
        driver.findElement(By.cssSelector(".signup-form [name='name']")).sendKeys(userName);
        driver.findElement(By.cssSelector(".signup-form [name='email']")).sendKeys(email);
        driver.findElement(By.cssSelector(".signup-form button")).click();
    }
    public void putInAccountDetails(String firstName, String lastName, String password, String company, String address, String state, String zipcode, String mobile_number, String city) {

        WebElement element;


        element = driver.findElement(By.name("first_name"));
        element.sendKeys(firstName);

        element = driver.findElement(By.name("password"));
        element.sendKeys(password);

        element = driver.findElement(By.name("last_name"));
        element.sendKeys(lastName);

        element = driver.findElement(By.name("company"));
        element.sendKeys(company);

        element = driver.findElement(By.name("address1"));
        element.sendKeys(address);

        element = driver.findElement(By.name("state"));
        element.sendKeys(state);

        element = driver.findElement(By.name("zipcode"));
        element.sendKeys(zipcode);

        element = driver.findElement(By.name("mobile_number"));
        element.sendKeys(mobile_number);

        element = driver.findElement(By.name("city"));
        element.sendKeys(city);

        driver.findElement(By.cssSelector("button[data-qa='create-account']")).click();

        driver.findElement(By.cssSelector("a[data-qa='continue-button']")).click();

        //return new HomePage(driver);

    }

    public void clickLoginButton() {
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")).click(); //change the xpath
    }

    public void clickingActualLoginButton() {
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div[1]/form/button")).click();
    }

    public void isTheLoginToYourAccountMessageDisplayed() {
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/h2")).click();
    }

    public void enteringIncorrectEmailAndPassword() {
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]")).sendKeys("correct_email@example.com");
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]")).sendKeys("correct_password");
    }

    public void checkThatTheUsernameOnTheTopIsCorrect() {
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a/b")).equals("Omar");
    }

    public void clickTheLogoutButton() {
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")).click();
    }

    public SignupLoginPage putInMyAccountDetails() {
        driver.navigate().to("https://automationexercise.com/signup");
        driver.findElement(By.id("id_gender1")).click();
        driver.findElement(By.name("name")).sendKeys("Reg");
        driver.findElement(By.name("email")).sendKeys("RHoward@spartaGlobal.com");
        driver.findElement(By.name("password")).sendKeys("password");
        driver.findElement(By.name("days")).sendKeys(Keys.chord(Keys.NUMPAD2, Keys.NUMPAD4, Keys.ENTER));
        driver.findElement(By.name("months")).sendKeys("April");
        driver.findElement(By.name("years")).sendKeys("1995");
        driver.findElement(By.name("first_name")).sendKeys("Reggie");
        driver.findElement(By.name("last_name")).sendKeys("Howard");
        driver.findElement(By.name("address1")).sendKeys("Some Address");
        driver.findElement(By.name("country")).sendKeys("United States");
        driver.findElement(By.name("state")).sendKeys("Montana");
        driver.findElement(By.name("city")).sendKeys("Libby");
        driver.findElement(By.name("zipcode")).sendKeys("59923");
        driver.findElement(By.name("mobile_number")).sendKeys("456841531");
        driver.findElement(By.tagName("button")).click();
        checkAccountWasCreated();
        return new SignupLoginPage(driver);
    }
    public void checkAccountWasCreated() {
        assertEquals("https://automationexercise.com/account_created", driver.getCurrentUrl());
    }
    public void refreshNow() {
        driver.navigate().refresh();
    }
}