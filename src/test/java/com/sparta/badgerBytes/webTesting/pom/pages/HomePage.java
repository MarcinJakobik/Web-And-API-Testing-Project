package com.sparta.badgerBytes.webTesting.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
  private final WebDriver driver;
  By contactUsLink = new By.ByCssSelector("a[href='/contact_us']");
  By loginLink = new By.ByCssSelector("a[href='/login']");

  public HomePage(WebDriver webDriver) {
    this.driver = webDriver;
    goToHomePage();
  }
  public String getUrl() {
    return driver.getCurrentUrl();
  }

  private void goToHomePage() {
    driver.get("https://automationexercise.com/");
  }

  public ContactUsPage goToContactUsPage() {
    driver.findElement(contactUsLink).click();
    return new ContactUsPage(driver);
  }

  public SignupLoginPage goToLoginPage() {
    driver.findElement(loginLink).click();
    return new SignupLoginPage(driver);
  }
}
