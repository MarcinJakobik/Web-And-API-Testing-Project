package com.sparta.badgerBytes.webTesting.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
  private final WebDriver driver;
  By someLink = new By.ByLinkText("something"); // edit and use as necessary

  public HomePage(WebDriver webDriver) {
    this.driver = webDriver;
    goToHomePage();
  }

  private void goToHomePage() {
    driver.get("https://automationexercise.com/");
  }
}
