package org.binar.stepdefs;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.binar.pages.HomePage;
import org.testng.Assert;

import static org.binar.BaseTest.driver;

public class SortingStepDef {

    HomePage homePage = new HomePage(driver);

    @When("user filter option low to high")
    public void chooseFilterLowToHigh(){
        homePage.clickFilter();
        homePage.clickLoHi();
    }

    @Then("compare first product price with second product price")
    public void compareProductsPrice() {
        homePage.isProductSortedLowToHigh();
    }

}
