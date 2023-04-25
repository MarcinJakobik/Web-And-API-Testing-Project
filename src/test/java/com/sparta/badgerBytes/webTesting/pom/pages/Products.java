package com.sparta.badgerBytes.webTesting.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Products {

  protected final WebDriver driver;

  By productsList = By.cssSelector("body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div");
  public Products(WebDriver webDriver) {
    this.driver = webDriver;
  }

  public boolean getProductsList() {
    return driver.findElement(productsList).isDisplayed();
  }

}
