package com.sparta.badgerBytes.webTesting.pom.pages;

import org.openqa.selenium.WebDriver;

public class Cart extends Footer{
    public Cart(WebDriver webDriver) {
        super(webDriver);
        goToCartPage();
    }

    private void goToCartPage() {
        driver.get("https://automationexercise.com/view_cart");
    }
}

