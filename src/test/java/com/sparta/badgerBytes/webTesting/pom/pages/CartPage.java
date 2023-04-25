package com.sparta.badgerBytes.webTesting.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends SuperFooterPage {

    public CartPage(WebDriver driver) {

        super(driver);
    }

    public String getUrl(){
        return driver.getCurrentUrl();}

    public boolean checkByClass(String pageClass){

        try {
            WebElement element = driver.findElement(By.className(pageClass));
        } catch (NoSuchElementException e){
            return false;
        }
        return true;
    }

    public SignupLoginPage proceedToCheckoutRegister(){
        driver.findElement(By.linkText("Proceed To Checkout")).click();
        driver.findElement(By.linkText("Register / Login")).click();
        return new SignupLoginPage(driver);
    }

    public CheckoutPage proccedToCheckout(){

        driver.findElement(By.linkText("Proceed To Checkout")).click();
        return new CheckoutPage(driver);
    }

    public void deleteItemFromCart(){
        driver.findElement(By.cssSelector(".cart_delete")).click();
    }

    public String checkCartIsEmpty(){
        WebElement element=driver.findElement(By.cssSelector(".cart_info p [b='Cart is empty!']"));
        return element.getText();
    }
    public int checkNumberOfProductsInCart() {
        return driver.findElements(By.cssSelector(".cart_info tbody tr")).size();
    }

    public double returnPrice(String productId){
        WebElement element = driver.findElement(By.id("product-" + productId));
        double price = Double.parseDouble(element.findElement(By.className("cart_price")).getText().substring(4));
        return price;
    }
    public double returnQuantity(String productId){
        WebElement element = driver.findElement(By.id("product-" + productId));
        double quantity = Double.parseDouble(element.findElement(By.className("cart_quantity")).getText());
        return quantity;
    }
    public double returnTotal(String productId){
        WebElement element = driver.findElement(By.id("product-" + productId));
        double total = Double.parseDouble(element.findElement(By.className("cart_total")).getText().substring(4));
        return total;
    }

    public boolean checkIfTotalPriceIsCorrect(Double price, Double quantity, Double total) {
        if (price * quantity == total) {
            return true;
        } else {
            return false;
        }
    }
}