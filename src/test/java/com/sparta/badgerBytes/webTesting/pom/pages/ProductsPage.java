package com.sparta.badgerBytes.webTesting.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage extends SuperFooterPage {

  //protected final WebDriver driver;

  private By productsListSelector = By.cssSelector("body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div");
  private By productDetailsSelector = By.cssSelector("a[href='/product_details/1']");

  public ProductsPage(WebDriver webDriver) {
    super(webDriver);
  }

  public boolean getProductsList() {
    return driver.findElement(productsListSelector).isDisplayed();
  }

  public String getURL() {
    return driver.getCurrentUrl();
  }

  public ProductDetailsPage goToProductDetails() {
    driver.findElement(productDetailsSelector).click();
    return new ProductDetailsPage(driver);
  }
  public CartPage goToCartPage() {
    driver.findElement(By.linkText("Cart")).click();
    return new CartPage(driver);
  }

  public void AddProductToCart(String productId, String quantity) {
    WebElement element = driver.findElement(By.cssSelector("a[href='/product_details/" + productId + "'][style='color: brown;'] > i.fa.fa-plus-square"));
    element.click();
    element = driver.findElement(By.id("quantity"));
    element.clear();
    element.sendKeys(quantity);
    element = driver.findElement(By.cssSelector("button.btn.btn-default.cart > i.fa.fa-shopping-cart"));
    element.click();
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

  public void continueShopping() {
    WebElement element = driver.findElement(By.cssSelector("button.btn.btn-success.close-modal.btn-block"));

    element.click();
  }

  public void goToProductsPage(){
    driver.findElement(By.cssSelector("a[href='/products'] >  i.material-icons.card_travel")).click();
  }


  public void turnOffAd() {
    if (driver.getCurrentUrl().contains("#")) {
      driver.manage().window().setSize(new Dimension(485, 800));
      try {
        Thread.sleep(3000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }
}
