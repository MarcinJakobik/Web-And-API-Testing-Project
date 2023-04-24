package com.sparta.badgerBytes.webTesting.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;

public class PastPage {

  private final WebDriver driver;
  private By dateElement = By.cssSelector(".pagetop font");

  public PastPage(WebDriver driver) {
    this.driver = driver;
  }

  public String getUrl() {
    return driver.getCurrentUrl();
  }

  public boolean checkDateOnPastPageYesterday() {
    String yesterday = LocalDate.now().minusDays(1).toString();
    String pastDate = driver.findElement(dateElement).getText();
    return pastDate.contains(yesterday);
  }
}
