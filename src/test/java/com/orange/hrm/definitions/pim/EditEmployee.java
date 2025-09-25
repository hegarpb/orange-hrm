package com.orange.hrm.definitions.pim;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.orange.hrm.Hooks;
import com.orange.hrm.pages.LoginPage;
import com.orange.hrm.pages.PimPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EditEmployee {

    private WebDriver driver;
    private LoginPage loginPage;
    private PimPage pimPage;

     public EditEmployee() {
        this.driver = Hooks.getDriver(); // ambil driver dari Hooks
        this.loginPage = new LoginPage(driver);
        this.pimPage = new PimPage(driver);
    }

    @Given("user sudah login dan berada di halaman PIM")
    public void navigateToPimPage(){
        loginPage.performLogin();
        pimPage.navigateToPimPage();
    }

    @When("user memilih data employee {string}")
    public void inputName(String name) throws InterruptedException{
        pimPage.inputEmployeeName(name);
        Thread.sleep(10000);
        pimPage.clickSearchBtn();
    }

    @And("user menekan tombol edit")
    public void clickEditBtn(){
        pimPage.clickEditButton();
    }

    @Then("muncul data employee yang akan di edit")
    public void employeDetail(){
        Assert.assertTrue(pimPage.isEmployeeImageDisplayed());
    }
}
