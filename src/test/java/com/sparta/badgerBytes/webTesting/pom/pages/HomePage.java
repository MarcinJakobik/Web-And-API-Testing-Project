package com.sparta.badgerBytes.webTesting.pom.pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends Footer {

  public HomePage(WebDriver webDriver) {
    super(webDriver);
    goToHomePage();
  }

  private void goToHomePage() {
    driver.get("https://automationexercise.com/");
  }

}
