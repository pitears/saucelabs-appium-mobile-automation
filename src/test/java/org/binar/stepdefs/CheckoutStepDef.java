package org.binar.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.binar.pages.CartPage;
import org.binar.pages.HomePage;

import static org.binar.BaseTest.driver;

public class CheckoutStepDef {
    HomePage homePage = new HomePage(driver);
    CartPage cartPage = new CartPage(driver);

    @When("user click Add To Cart button on two products")
    public void addToCartBackPackAndOnesie(){
        homePage.clickAddToCartBackpack();
        homePage.clickAddToCartOnesie();
    }

    @And("user do checkout")
    public void doCheckout(){
        homePage.clickCart();
        cartPage.checkout("Song", "Kang", "12345");
    }

    @Then("verify checkout successfully with title {string}")
    public void verifyCheckoutSuccessfully(String elementText){
        cartPage.verifySuccessCheckoutTextExist(elementText);
    }
}
