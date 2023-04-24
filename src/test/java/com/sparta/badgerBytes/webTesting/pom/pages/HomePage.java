package com.sparta.badgerBytes.webTesting.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
  private final WebDriver driver;
  By pastLink = new By.ByLinkText("past");
  By commentsLink = new By.ByLinkText("comments");

  public HomePage(WebDriver webDriver) {
    this.driver = webDriver;
    goToHomePage();
  }

  private void goToHomePage() {
    driver.get("https://news.ycombinator.com/");
  }

  public CommentsPage goToCommentsPage() {
    driver.findElement(commentsLink).click();
    return new CommentsPage(driver);
  }

  public PastPage goToPastPage() {
    driver.findElement(pastLink).click();
    return new PastPage(driver);
  }
}
