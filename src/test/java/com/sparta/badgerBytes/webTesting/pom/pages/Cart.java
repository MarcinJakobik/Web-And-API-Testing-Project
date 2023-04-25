package com.sparta.badgerBytes.webTesting.pom.pages;

import io.cucumber.java.ro.Si;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Cart {

    WebDriver driver;
    public Cart(WebDriver driver) {
        this.driver = driver;
    }

    public String getUrl(){return driver.getCurrentUrl();}

    public boolean checkByClass(String pageClass){

        try {
            WebElement element = driver.findElement(By.className(pageClass));
        } catch (NoSuchElementException e){
            return false;
        }
        return true;
    }

    public SignupLogin proceedToCheckoutRegister(){
        driver.findElement(By.linkText("Proceed To Checkout")).click();
        driver.findElement(By.linkText("Register / Login")).click();
        return new SignupLogin(driver);
    }

    public Checkout proccedToCheckout(){

        driver.findElement(By.linkText("Proceed To Checkout")).click();
        return new Checkout(driver);
    }

    public void deleteItemFromCart(){
        driver.findElement(By.cssSelector(".cart_delete")).click();
    }

    public String checkCartIsEmpty(){
        WebElement element=driver.findElement(By.cssSelector(".cart_info p [b='Cart is empty!']"));
        return element.getText();
    }


}
