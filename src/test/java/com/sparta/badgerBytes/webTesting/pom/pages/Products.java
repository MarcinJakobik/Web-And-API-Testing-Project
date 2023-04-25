package com.sparta.badgerBytes.webTesting.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Products {

  protected final WebDriver driver;

  private By productsListSelector = By.cssSelector("body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div");
  private By productDetailsSelector = By.cssSelector("a[href='/product_details/1']");

  public Products(WebDriver webDriver) {
    this.driver = webDriver;
  }

  public boolean getProductsList() {
    return driver.findElement(productsListSelector).isDisplayed();
  }

  public String getURL() {
    return driver.getCurrentUrl();
  }

  public ProductDetails goToProductDetails() {
    driver.findElement(productDetailsSelector).click();
    return new ProductDetails(driver);
  }

}
