package com.sparta.badgerBytes.webTesting.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//rename this class to Checkout/Payment
public class Checkout {

    private WebDriver driver;
    public Checkout(WebDriver driver) {
        this.driver = driver;
    }

    public String getCurrentURL(){ return driver.getCurrentUrl();}

    public void placeOrderButton(){driver.findElement(By.linkText("Place Order")).click();}

    public boolean putInPaymentDetailsAndConfirmOrder(String nameOnCard, String cardNum, String cvc, String yearExpire, String monthExpire){


        driver.findElement(By.name("name_on_card")).sendKeys(nameOnCard);
        driver.findElement(By.name("card_number")).sendKeys(cardNum);
        driver.findElement(By.name("cvc")).sendKeys(cvc);
        driver.findElement(By.name("expiry_year")).sendKeys(yearExpire);
        driver.findElement(By.name("expiry_month")).sendKeys(monthExpire);
        driver.findElement(By.id("submit")).click();

        try {
            driver.findElements(By.cssSelector(".title.text-center[data-qa='order-placed']"));
            driver.findElement(By.cssSelector(".btn.btn-primary")).click();
        } catch (NoSuchElementException e){
            return false;
        }
        //on homepage now
        return true;
    }
}
