package org.binar.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CartPage {

    WebDriverWait wait;
    AndroidDriver driver;

    //HomePage homePage = new HomePage(driver);

    By checkoutButton = AppiumBy.accessibilityId("test-CHECKOUT");
    By firstNameTextBox = AppiumBy.accessibilityId("test-First Name");
    By lastNameTextBox = AppiumBy.accessibilityId("test-Last Name");
    By zipCodeTextBox = AppiumBy.accessibilityId("test-Zip/Postal Code");
    By continueButton = AppiumBy.accessibilityId("test-CONTINUE");
    By finishButton = AppiumBy.accessibilityId("test-FINISH");
    By successCheckoutText = AppiumBy.xpath("//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: COMPLETE!\"]/android.view.ViewGroup/android.widget.TextView[1]");

    public CartPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
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

    public void clickCheckout() {
        wait.until(ExpectedConditions.presenceOfElementLocated(checkoutButton));
        driver.findElement(checkoutButton).click();
    }

    public void inputFirstName(String firstName) {
        wait.until(ExpectedConditions.presenceOfElementLocated(firstNameTextBox));
        driver.findElement(firstNameTextBox).sendKeys(firstName);
    }

    public void inputLastName(String lastName) {
        wait.until(ExpectedConditions.presenceOfElementLocated(lastNameTextBox));
        driver.findElement(lastNameTextBox).sendKeys(lastName);
    }

    public void inputZipCode(String zipCode) {
        wait.until(ExpectedConditions.presenceOfElementLocated(zipCodeTextBox));
        driver.findElement(zipCodeTextBox).sendKeys(zipCode);
    }

    public void clickContinue() {
        wait.until(ExpectedConditions.presenceOfElementLocated(continueButton));
        driver.findElement(continueButton).click();
    }

    public void clickFinish() {
        wait.until(ExpectedConditions.presenceOfElementLocated(finishButton));
        driver.findElement(finishButton).click();
    }

    public void checkout(String firstName, String lastName, String zipCode){
        swipeToElementWithText("CHECKOUT");
        clickCheckout();
        inputFirstName(firstName);
        inputLastName(lastName);
        inputZipCode(zipCode);
        clickContinue();
        swipeToElementWithText("FINISH");
        clickFinish();
    }

    public void verifySuccessCheckoutTextExist(String expectedText){
        wait.until(ExpectedConditions.presenceOfElementLocated(successCheckoutText));
        WebElement el = driver.findElement(successCheckoutText);
        String actualText = el.getText();
        Assert.assertEquals(actualText, expectedText);
    }
}
