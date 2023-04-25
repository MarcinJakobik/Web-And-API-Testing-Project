package com.sparta.badgerBytes.webTesting.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import com.sparta.badgerBytes.webTesting.pom.pages.Cart;
import com.sparta.badgerBytes.webTesting.pom.pages.Checkout;
import com.sparta.badgerBytes.webTesting.pom.pages.HomePage;
import com.sparta.badgerBytes.webTesting.pom.pages.SignupLogin;
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
    private static ChromeDriverService service;

    private static WebDriver webDriver;

    private static final String DRIVER_LOCATION = "src/test/resources/chromedriver";

    private HomePage homePage;

    private Cart cart;

    private Checkout checkout;

    private SignupLogin signupLogin;


    @BeforeEach
    public void setup(){

        service = WebAutomationUtil.getChromeDriverService(DRIVER_LOCATION);

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        //chromeOptions.addArguments("headless"); //noGUI
        webDriver = new ChromeDriver(service,chromeOptions);
        webDriver.get("https://automationexercise.com/");

    }

    @Test
    @DisplayName("Test")
    void test()
    {
        // webDriver.findElement(By.id("1")).click();
        //webDriver.findElement(By.className("btn btn-default add-to-cart")).findElement(By.id("1")).click();
        WebElement addToCartButton = webDriver.findElement(By.cssSelector("a.add-to-cart")); addToCartButton.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //webDriver.findElement(By.className("button.btn btn-success close-modal btn-block")).click();
        //webDriver.findElement(By.xpath("//button[contains(text(), 'Continue Shopping')]")).click();
        webDriver.findElement(By.cssSelector("button.btn.btn-success.close-modal.btn-block")).click();

        webDriver.findElement(By.linkText("Cart")).click();



        String userName = "liam";
        WebElement element = webDriver.findElement(By.name("name"));
        element.sendKeys(userName);
        element = webDriver.findElement(By.cssSelector("input[data-qa='signup-email']"));
        element.sendKeys("Marcin@ExampleEmail.com");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }



        webDriver.findElement(By.cssSelector("button[data-qa='signup-button']")).click();

        element = webDriver.findElement(By.name("first_name"));
        element.sendKeys("Example@Example");

        element = webDriver.findElement(By.name("password"));
        element.sendKeys("Example@Example");

        element = webDriver.findElement(By.name("last_name"));
        element.sendKeys("Example@Example");

        element = webDriver.findElement(By.name("company"));
        element.sendKeys("Example@Example");

        element = webDriver.findElement(By.name("address1"));
        element.sendKeys("Example@Example");

        element = webDriver.findElement(By.name("state"));
        element.sendKeys("Example@Example");

        element = webDriver.findElement(By.name("zipcode"));
        element.sendKeys("Example@Example");

        element = webDriver.findElement(By.name("mobile_number"));
        element.sendKeys("Example@Example");

        element = webDriver.findElement(By.name("city"));
        element.sendKeys("ExampleCity");

//        element = webDriver.findElement(By.name("country"));
//        element.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        webDriver.findElement(By.cssSelector("button[data-qa='create-account']")).click();

        webDriver.findElement(By.cssSelector("a[data-qa='continue-button']")).click();

        element = webDriver.findElement(By.cssSelector("a i.fa.fa-user + b"));
        System.out.println(element.getText().contains(userName));

    }

    @After
    public void destroy(){
        webDriver.quit();
         service.stop();
    }

}
