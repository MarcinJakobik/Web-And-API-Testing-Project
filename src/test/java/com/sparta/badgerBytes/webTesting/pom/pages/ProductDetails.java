package com.sparta.badgerBytes.webTesting.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetails {

  protected final WebDriver driver;

  private By productInfoSelector = By.className("product-information");
  public ProductDetails(WebDriver driver) {
    this.driver = driver;
  }

  public boolean productInfoDivDisplayed() {
    return driver.findElement(productInfoSelector).isDisplayed();
  }

}
