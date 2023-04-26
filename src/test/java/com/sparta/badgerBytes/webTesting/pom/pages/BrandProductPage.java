package com.sparta.badgerBytes.webTesting.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BrandProductPage {
    private final WebDriver driver;
    public BrandProductPage(WebDriver webDriver) {
        this.driver = webDriver;
        if (driver.getCurrentUrl().contains("#google_vignette")) {
            driver.manage().window().setSize(new Dimension(485, 800));
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public BrandProductPage goToBrandPage(String brandName){
        driver.manage().window().setSize(new Dimension(800, 800));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
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

    private void turnOffAd() {
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
