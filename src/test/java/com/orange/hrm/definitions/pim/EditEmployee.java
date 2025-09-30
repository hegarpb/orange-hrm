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
    public void navigateToPimPage() {
        loginPage.performLogin();
        pimPage.navigateToPimPage();
    }

    @When("user memilih data employee {string}")
    public void inputName(String name) throws InterruptedException {
        pimPage.inputEmployeeName(name);
        Thread.sleep(2000);
        pimPage.clickSearchBtn();
    }

    @And("user menekan tombol edit")
    public void clickEditBtn() {
        pimPage.clickEditButton();

    }

    @And("user mengisi field first name {string}")
    public void setFirstname(String firstName) throws InterruptedException {
        pimPage.setFirstName(firstName);
        Thread.sleep(2000);
    }

    @And("user mengisi field middle name {string}")
    public void setMiddleName(String middleName) throws InterruptedException {
        pimPage.setMiddleName(middleName);
        Thread.sleep(2000);
    }

    @And("user mengisi field last name {string}")
    public void setLastName(String lastName) throws InterruptedException {
        pimPage.setLastName(lastName);
        Thread.sleep(2000);
    }

    @And("user mengisi field employee id {string}")
    public void setEmployeeId(String employeeId) {
        pimPage.setEmployeeId(employeeId);
    }

    @And("user mengisi field other id {string}")
    public void setOtherId(String otherId) throws InterruptedException {
        pimPage.setOtherId(otherId);
        Thread.sleep(2000);
    }

    @And("user mengisi field license number {string}")
    public void setLicenseNumber(String licenseNumber) throws InterruptedException {
        pimPage.setDriversLicense(licenseNumber);
        Thread.sleep(2000);
    }

    @And("user mengisi field license expiry date {string}")
    public void setExpiryDate(String expiryDate) throws InterruptedException {
        pimPage.setLicenseExpiredDate(expiryDate);
        Thread.sleep(2000);
    }

    @And("user mengisi field nationality {string}")
    public void setNationality(String nationality) throws InterruptedException {
        pimPage.setNationality(nationality);
        Thread.sleep(2000);
    }

    @And("user mengisi field marital status {string}")
    public void setMaritalStatus(String maritalStatus) {
        pimPage.setMaritalStatus(maritalStatus);
    }

    @And("user mengisi field date of birth {string}")
    public void setDateofBirth(String dob) {
        pimPage.setDateOfBirth(dob);
    }

    @And("user memilih gender {string}")
    public void selectGender(String gender) throws InterruptedException {
        pimPage.selectGender(gender);
        Thread.sleep(2000);
    }

    @And("user menekan tombol save")
    public void savePersonalDetail() throws InterruptedException {
        pimPage.clickSavePersonalDetailBtn();
    }

    @Then("muncul pesan sukses {string}")
    public void employeDetail(String pesan) {
        String actualMessage = pimPage.waitForToast();
        Assert.assertEquals(actualMessage, pesan);
    }

}
