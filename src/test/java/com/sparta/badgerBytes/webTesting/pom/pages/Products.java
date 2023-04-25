package com.sparta.badgerBytes.webTesting.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Products {
    private final WebDriver webDriver;

    public Products(WebDriver driver) {
        this.webDriver = driver;
    }


    public String getUrl() {
        turnOffAd();
        return webDriver.getCurrentUrl();
    }

    public void AddProductToCart(String productId, String quantity) {
        WebElement element = webDriver.findElement(By.cssSelector("a[href='/product_details/" + productId + "'][style='color: brown;'] > i.fa.fa-plus-square"));
        element.click();
        element = webDriver.findElement(By.id("quantity"));
        element.clear();
        element.sendKeys(quantity);
        element = webDriver.findElement(By.cssSelector("button.btn.btn-default.cart > i.fa.fa-shopping-cart"));
        element.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void continueShopping() {
        WebElement element = webDriver.findElement(By.cssSelector("button.btn.btn-success.close-modal.btn-block"));

        element.click();
    }

    public void goToProductsPage(){
        webDriver.findElement(By.cssSelector("a[href='/products'] >  i.material-icons.card_travel")).click();
    }


    public void turnOffAd() {
        if (webDriver.getCurrentUrl().contains("#")) {
            webDriver.manage().window().setSize(new Dimension(485, 800));
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Cart goToCartPage() {
        webDriver.findElement(By.linkText("Cart")).click();
        return new Cart(webDriver);
    }
}
