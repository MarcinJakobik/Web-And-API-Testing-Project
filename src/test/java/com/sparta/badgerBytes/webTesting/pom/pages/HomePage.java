package com.sparta.badgerBytes.webTesting.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends Footer {

  public HomePage(WebDriver webDriver) {
    super(webDriver);
    goToHomePage();
  }

  public String getUrl() {
    return driver.getCurrentUrl();
  }

  private void goToHomePage() {
    driver.get("https://automationexercise.com/");
  }

  public Cart goToCartPage() {
    driver.findElement(By.cssSelector("a[href='/view_cart']")).click();
    return new Cart(driver);
  }

  public Products goToProductsPage() {
    driver.findElement(By.cssSelector("a[href='/products']")).click();
    return new Products(driver);
  }

}
