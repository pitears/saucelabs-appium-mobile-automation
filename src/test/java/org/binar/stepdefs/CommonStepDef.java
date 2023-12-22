package org.binar.stepdefs;

import io.cucumber.java.en.Given;
import org.binar.pages.LoginPage;

import static org.binar.BaseTest.driver;

public class CommonStepDef {
    LoginPage loginPage = new LoginPage(driver);

    @Given("user is on the login page")
    public void userLoginPage(){
        loginPage.validateOnLoginPage();
    }
}

