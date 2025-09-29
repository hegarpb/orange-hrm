package com.orange.hrm.definitions.pim;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;

import com.orange.hrm.Hooks;
import com.orange.hrm.pages.LoginPage;
import com.orange.hrm.pages.PimPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddEmployee {
    private WebDriver driver;
    private LoginPage loginPage;
    private PimPage pimPage;

    public AddEmployee() {
        this.driver = Hooks.getDriver();
        this.loginPage = new LoginPage(driver);
        this.pimPage = new PimPage(driver);
    }

    @Given("user sudah melakukan login dan berada di halaman PIM")
    public void navigateToPimPage() {
        loginPage.performLogin();
        pimPage.navigateToPimPage();
    }

    @When("user memilih menu add employee")
    public void clickAddEmployeeMenu() {
        pimPage.clickAddEmployeMenu();
    }

    @And("user mengisi first name {string}")
    public void setFirstName(String firstName) {
        pimPage.setFirstName(firstName);
    }

    @And("user mengisi middle name {string}")
    public void setMiddleName(String middleName) {
        pimPage.setMiddleName(middleName);
    }

    @And("user mengisi last name {string}")
    public void setLastName(String lastName) {
        pimPage.setLastName(lastName);
    }

    @And("user mengunggah foto profil")
    public void uploadPhoto() throws AWTException {
        pimPage.uploadPhotoWithRobot();
    }

    @And("user menekan tombol save.")
    public void clickBtnSave() {
        pimPage.clickSaveAddEmployee();
    }

    @Then("muncul pesan sukses. {string}")
    public void getPesanSukses(String pesan) {
        pimPage.waitForToast();
    }

}
