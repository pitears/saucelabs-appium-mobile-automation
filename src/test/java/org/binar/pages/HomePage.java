package org.binar.pages;

import org.openqa.selenium.WebElement;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;


public class HomePage {
    WebDriverWait wait;
    AndroidDriver driver;


    By productTitle = AppiumBy.accessibilityId("test-Cart drop zone");
    By filterButton = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Modal Selector Button\"]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView");
    By loHiButton = AppiumBy.xpath("//android.widget.ScrollView[@content-desc=\"Selector container\"]/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup/android.widget.TextView");
    By addToCartBackpack = AppiumBy.xpath("(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[1]/android.widget.TextView");
    By addToCartOnesie = AppiumBy.xpath("(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[3]/android.widget.TextView");
    By cartButton = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.ImageView");

    public HomePage(AndroidDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    public void validateOnHomePage(){
        wait.until(ExpectedConditions.presenceOfElementLocated(productTitle));
        WebElement el = driver.findElement(productTitle);
        Assert.assertEquals(el.getTagName(), "test-Cart drop zone");
    }

    public void clickFilter(){
        wait.until(ExpectedConditions.presenceOfElementLocated(filterButton));
        driver.findElement(filterButton).click();
    }

    public void clickLoHi(){
        wait.until(ExpectedConditions.presenceOfElementLocated(loHiButton));
        driver.findElement(loHiButton).click();
    }

    public String getProductPriceByIndex(int index) {
        By priceLocator = AppiumBy.xpath("(//android.widget.TextView[@content-desc=\"test-Price\"])[" + index + "]");
        WebElement priceElement = wait.until(ExpectedConditions.presenceOfElementLocated(priceLocator));
        return priceElement.getText();
    }

    public void isProductSortedLowToHigh(){
        String product1Price = getProductPriceByIndex(1);
        String product2Price = getProductPriceByIndex(2);

        double price1 = Double.parseDouble(product1Price.replace("$", ""));
        double price2 = Double.parseDouble(product2Price.replace("$", ""));

        Assert.assertTrue(price1 < price2, "Product1 price is not less than Product2 price");
    }

    public void swipeToElementWithText(String elementText){
        try {
            driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true))" +
                            ".scrollIntoView(new UiSelector().text(\"" + elementText + "\"))"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void clickAddToCartBackpack(){
        wait.until(ExpectedConditions.presenceOfElementLocated(addToCartBackpack));
        driver.findElement(addToCartBackpack).click();
    }

    public void clickAddToCartOnesie(){
        swipeToElementWithText("Sauce Labs Onesie");
        wait.until(ExpectedConditions.presenceOfElementLocated(addToCartOnesie));
        driver.findElement(addToCartOnesie).click();
    }

     public void clickCart(){
         wait.until(ExpectedConditions.presenceOfElementLocated(cartButton));
         driver.findElement(cartButton).click();
     }
}

