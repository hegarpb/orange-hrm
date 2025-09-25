package com.orange.hrm.definitions.auth;

import org.testng.Assert;

import com.orange.hrm.Hooks;
import com.orange.hrm.pages.LoginPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Authentication {

    private LoginPage loginPage;
    
    @Given("user berada pada halaman login")
    public void halamanLogin(){
        
        this.loginPage= new LoginPage(Hooks.getDriver());
    }

    @When("user memasukan username {string}")
    public void setUsername(String username){
        loginPage.setUsername(username);
    }

    @And("user memasukan password {string}")
    public void setPassword(String password){
        loginPage.setPassword(password);
    }

    @And("user menekan tombol login")
    public void clickLoginBtn() throws InterruptedException{
        loginPage.clickButtonLogin();
        Thread.sleep(2000);
    }

    @Then("user diarahkan ke halaman dashboard {string}")
    public void navigateToDashboard(String url){
        String actual = loginPage.getCurrentUrl();
        Assert.assertEquals(actual, url);
    }

    @Then("muncul pesan error {string}")
    public void errMessage(String pesan){
        String message= loginPage.getErrMessage();
        Assert.assertEquals(pesan, message);
    }
    
    @Then("muncul pesan validasi {string}")
    public void validateMessage(String pesan)
    {
        String validate= loginPage.getValidationField();
        Assert.assertEquals(pesan, validate);
    }
    



    
}
