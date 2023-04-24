package com.sparta.badgerBytes.webTesting.pom.pages;

import org.openqa.selenium.WebDriver;

public class CommentsPage {
  private final WebDriver driver;
//  private By pageTop = new By.ByClassName("pagetop");
  public CommentsPage(WebDriver driver) {
    this.driver = driver;
  }

  public String getUrl() {
    return driver.getCurrentUrl();
  }
}
