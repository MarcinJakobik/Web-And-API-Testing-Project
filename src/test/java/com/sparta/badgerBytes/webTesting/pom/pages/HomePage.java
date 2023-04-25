package com.sparta.badgerBytes.webTesting.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

  public BrandProductPage goToBrandPage(String brandName){
    driver.findElement(By.partialLinkText(brandName.toUpperCase())).click();
    return new BrandProductPage(driver);
  }

  public Cart goToCartPage(){

    driver.findElement(By.linkText("Cart")).click();
    return new Cart(driver);
  }

  public TestCasesPage goToTestCasesPage(){
    driver.findElement(By.cssSelector(".test_cases_list")).click();
    return new TestCasesPage(driver);
  }

  public void clickContinueShopping(){ driver.findElement(By.cssSelector("button.btn.btn-success.close-modal.btn-block")).click();}

  public void addToCart(){
    WebElement addToCartButton = driver.findElement(By.cssSelector("a.add-to-cart"));
    addToCartButton.click();
  }

  public boolean checkIfLoggedInAsUser(String user){

    WebElement element;
    element = driver.findElement(By.cssSelector("a i.fa.fa-user + b"));

    if(element.getText().contains(user))
      return true;
    else
      return false;

  }

  public void deleteAccount(){
    driver.findElement(By.linkText("Delete Account")).click();
    driver.findElement(By.linkText("Continue")).click();
  }

  public SignupLogin goToSignUPLogin(){

    driver.findElement(By.cssSelector("a[href='/login']")).click();

    return new SignupLogin(driver);
  }

  public String getUrl(){
    return driver.getCurrentUrl();
  }

}
