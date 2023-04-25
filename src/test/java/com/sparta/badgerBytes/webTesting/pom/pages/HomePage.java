package com.sparta.badgerBytes.webTesting.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends SuperFooterPage {

    By contactUsLink = new By.ByCssSelector("a[href='/contact_us']");
    By loginLink = new By.ByCssSelector("a[href='/login']");

    public HomePage(WebDriver driver) {
        super(driver);
        goToHomePage();
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    private void goToHomePage() {
        driver.get("https://automationexercise.com/");
    }

    public ProductsPage goToProductsPage() {
        driver.findElement(By.cssSelector("a[href='/products']")).click();
        return new ProductsPage(driver);
    }

    public BrandProductPage goToBrandPage(String brandName) {
        turnOffAd();
        WebElement element = driver.findElement(By.cssSelector("a[href='/brand_products/"+brandName+"']"));
        turnOffAd();
        element.click();
        turnOffAd();
        return new BrandProductPage(driver);
    }

    public CartPage goToCartPage() {

        driver.findElement(By.cssSelector("a[href='/view_cart']")).click();
        return new CartPage(driver);
    }

    public TestCasesPage goToTestCasesPage() {
        driver.findElement(By.cssSelector(".test_cases_list")).click();
        return new TestCasesPage(driver);
    }

    public ContactUsPage goToContactUsPage() {
        driver.findElement(contactUsLink).click();
        return new ContactUsPage(driver);
    }

    public SignupLoginPage goToLoginPage() {
        driver.findElement(loginLink).click();
        return new SignupLoginPage(driver);
    }

    public void clickContinueShopping() {
        driver.findElement(By.cssSelector("button.btn.btn-success.close-modal.btn-block")).click();
    }

    public void addToCart() {
        WebElement addToCartButton = driver.findElement(By.cssSelector("a.add-to-cart"));
        addToCartButton.click();
    }

    public boolean checkIfLoggedInAsUser(String user) {

        WebElement element;
        element = driver.findElement(By.cssSelector("a i.fa.fa-user + b"));

        if (element.getText().contains(user))
            return true;
        else
            return false;

    }

    public void deleteAccount() {
        driver.findElement(By.linkText("Delete Account")).click();
        driver.findElement(By.linkText("Continue")).click();
    }

    public SignupLoginPage goToSignUPLoginPage() {

        driver.findElement(By.cssSelector("a[href='/login']")).click();

        return new SignupLoginPage(driver);
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
