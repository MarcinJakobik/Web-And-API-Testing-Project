package com.sparta.badgerBytes.webTesting.cucumber;

import com.sparta.badgerBytes.webTesting.cucumber.stepdefs.BackgroundStepdefs;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import com.sparta.badgerBytes.webTesting.pom.pages.CartPage;
import com.sparta.badgerBytes.webTesting.pom.pages.CheckoutPage;
import com.sparta.badgerBytes.webTesting.pom.pages.HomePage;
import com.sparta.badgerBytes.webTesting.pom.pages.SignupLoginPage;
import com.sparta.badgerBytes.webTesting.pom.util.WebAutomationUtil;
import io.cucumber.java.After;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
@RunWith(Cucumber.class)
@CucumberOptions(
    features = {"src/test/resources/features"},
    plugin = {"pretty", "html:target/testReport.html", "json:target/jsonReport.json"}
)
public class TestRunner {

    private static WebDriver driver;

    private HomePage homePage;

    private CartPage cartPage;

    private CheckoutPage checkoutPage;

    private SignupLoginPage signupLoginPage;


    @BeforeEach
    public void setup(){
        driver = BackgroundStepdefs.getDriver();
    }

    @Test
    @DisplayName("Test")
    void test()
    {
        // driver.findElement(By.id("1")).click();
        //driver.findElement(By.className("btn btn-default add-to-cart")).findElement(By.id("1")).click();
        WebElement addToCartButton = driver.findElement(By.cssSelector("a.add-to-cart")); addToCartButton.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //driver.findElement(By.className("button.btn btn-success close-modal btn-block")).click();
        //driver.findElement(By.xpath("//button[contains(text(), 'Continue Shopping')]")).click();
        driver.findElement(By.cssSelector("button.btn.btn-success.close-modal.btn-block")).click();

        driver.findElement(By.linkText("Cart")).click();

        cartPage.proceedToCheckoutRegister();



        String userName = "liam";
        WebElement element = driver.findElement(By.name("name"));
        element.sendKeys(userName);
        element = driver.findElement(By.cssSelector("input[data-qa='signup-email']"));
        element.sendKeys("Marcin@ExampleEmail.com");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }



        driver.findElement(By.cssSelector("button[data-qa='signup-button']")).click();

        element = driver.findElement(By.name("first_name"));
        element.sendKeys("Example@Example");

        element = driver.findElement(By.name("password"));
        element.sendKeys("Example@Example");

        element = driver.findElement(By.name("last_name"));
        element.sendKeys("Example@Example");

        element = driver.findElement(By.name("company"));
        element.sendKeys("Example@Example");

        element = driver.findElement(By.name("address1"));
        element.sendKeys("Example@Example");

        element = driver.findElement(By.name("state"));
        element.sendKeys("Example@Example");

        element = driver.findElement(By.name("zipcode"));
        element.sendKeys("Example@Example");

        element = driver.findElement(By.name("mobile_number"));
        element.sendKeys("Example@Example");

        element = driver.findElement(By.name("city"));
        element.sendKeys("ExampleCity");

//        element = driver.findElement(By.name("country"));
//        element.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.findElement(By.cssSelector("button[data-qa='create-account']")).click();

        driver.findElement(By.cssSelector("a[data-qa='continue-button']")).click();

        element = driver.findElement(By.cssSelector("a i.fa.fa-user + b"));
        System.out.println(element.getText().contains(userName));

        homePage.goToCartPage();
        cartPage.proccedToCheckout();
        System.out.println(checkoutPage.putInPaymentDetailsAndConfirmOrder("liam","3243","434","3443","43"));

    }


}
