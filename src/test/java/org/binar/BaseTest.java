package org.binar;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

import java.time.Duration;


public class BaseTest {
    public static AndroidDriver driver;
    protected static WebDriverWait wait;

    public static void setupDriver(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "14.0");
        capabilities.setCapability("appPackage", "com.swaglabsmobileapp");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("appActivity", "com.swaglabsmobileapp.MainActivity");

        driver = new AndroidDriver(capabilities);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public static void stopDriver() {
        driver.quit();
    }

    public static void resetApp() {
        driver.terminateApp("com.swaglabsmobileapp");
        driver.activateApp("com.swaglabsmobileapp");
    }

//    @Test
//    public void simpleTestAppium() {
//        LoginPage loginPage = new LoginPage(driver);
//        HomePage homePage = new HomePage(driver);
//
//        loginPage.inputUsername("standard_user");
//        loginPage.inputPassword("secret_sauce");
//        loginPage.clickLogin();
//
//        homePage.validateOnLoginPage();
//        homePage.swipeToElementWithText("Sauce labs Onesie");
//    }

}
