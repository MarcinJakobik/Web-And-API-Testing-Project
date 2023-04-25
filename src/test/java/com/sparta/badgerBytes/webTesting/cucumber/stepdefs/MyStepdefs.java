package com.sparta.badgerBytes.webTesting.cucumber.stepdefs;

import com.sparta.badgerBytes.webTesting.pom.util.WebAutomationUtil;
import com.sparta.badgerBytes.webTesting.pom.pages.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

public class MyStepdefs {

  private static ChromeDriverService service;
  private static WebDriver driver;
  private static HomePage homePage;
  private static final String DRIVER_PATH = "src/test/java/resources/chromedriver";

  @Before
  public void setup() {
//    service = WebAutomationUtil.getChromeDriverService(DRIVER_PATH);
//    ChromeOptions options = new ChromeOptions();
//    options.addArguments("--remote-allow-origins=*");
////    options.addArguments("headless");
//    driver = new ChromeDriver(service, options);
//    driver.manage().window().maximize();
  }

  @After
  public void tearDown() {
    //driver.close();
   // driver.quit();
    //service.stop();
  }


}
