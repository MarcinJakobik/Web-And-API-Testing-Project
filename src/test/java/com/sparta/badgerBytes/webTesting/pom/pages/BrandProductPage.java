package com.sparta.badgerBytes.webTesting.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BrandProductPage {
    private static WebDriver driver;
    public BrandProductPage(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public BrandProductPage goToBrandPage(String brandName){
        driver.findElement(By.partialLinkText(brandName.toUpperCase())).click();
        return new BrandProductPage(driver);
    }

    public String getUrl(){
        return driver.getCurrentUrl();
    }

    public String getBrandProductListTitle(){
        return driver.findElement(By.cssSelector(".features_items > .text-center")).getText();
    }

    public int getBrandProductsCount(){
        return driver.findElements(By.cssSelector(".features_items .single-products")).size();
    }

    public int getExpectedBrandProductsCount(){
        String[] brandLinkSegments = getUrl().split("/");
        String brandLink = "/" + brandLinkSegments[brandLinkSegments.length - 1];
        brandLink = brandLink.replaceAll("%20", " ");
        return Integer.parseInt(
                driver.findElement(
                By.cssSelector("a[href='/brand_products" + brandLink + "'] .pull-right"))
                .getText().replaceAll("[()]", ""));
    }
}
