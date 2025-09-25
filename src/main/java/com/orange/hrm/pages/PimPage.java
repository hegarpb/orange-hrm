package com.orange.hrm.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PimPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By pagePim =By.xpath("//span[normalize-space()='PIM']");
    private By empName = By.xpath("//label[normalize-space()='Employee Name']");
    private By btnSearch= By.xpath("//button[normalize-space()='Search']");
    private By btnEdit= By.xpath("//i[@class='oxd-icon bi-pencil-fill']");
    private By empImg = By.xpath("//img[@class='employee-image']");
    private By firstName=  By.xpath("//input[@placeholder='First Name']");
    private By middleName= By.xpath("//input[@placeholder='Middle Name']");
    private By lastName= By.xpath("//input[@placeholder='Last Name']");
    private By nickName = By.xpath("//label[normalize-space()='Nickname']");
    private By otherId= By.xpath("//label[normalize-space()='Other Id']");
    private By driverLicenseNumber= By.xpath("//label[normalize-space()=\"Driver's License Number\"]");
    private By licenseExpiredDate= By.xpath("//label[normalize-space()='License Expiry Date']");
    private By ssnNumber= By.xpath("//label[normalize-space()='SSN Number']");
    private By sinNumber= By.xpath("//label[normalize-space()='SIN Number']");
    private By nationality= By.xpath("//label[normalize-space()='Nationality']");
    private By maritalStatus= By. xpath("//label[normalize-space()='Marital Status']");
    private By dateOfBirth = By.xpath("//label[normalize-space()='Date of Birth']");
    private By gender = By.xpath("//label[normalize-space()='Gender']");
    private By militaryService= By.xpath("//label[normalize-space()='Military Service']");
    private By smoker= By.xpath("//label[normalize-space()='Smoker']");
    //div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//button[@type='submit'][normalize-space()='Save']
    //div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//button[@type='submit'][normalize-space()='Save']
    //div[@class='orangehrm-custom-fields']//button[@type='submit'][normalize-space()='Save']
    //div[@class='orangehrm-custom-fields']//button[@type='submit'][normalize-space()='Save']


    public PimPage(WebDriver driver){
        this.driver=driver;
        this.wait= new WebDriverWait(driver,Duration.ofSeconds(5));
    }
    
    public void navigateToPimPage(){
        WebElement pimPage= wait.until(ExpectedConditions.elementToBeClickable(pagePim));
        pimPage.click();
    }

    public void inputEmployeeName(String value){
        WebElement labelEmpName= wait.until(ExpectedConditions.visibilityOfElementLocated(empName));
        WebElement inputEmpName= driver.findElement(with(By.tagName("input")).below(labelEmpName));
        inputEmpName.clear();
        inputEmpName.sendKeys(value);
    }

    public void clickSearchBtn(){
        WebElement searchBtn= wait.until(ExpectedConditions.elementToBeClickable(btnSearch));
        searchBtn.click();
    }
    
    public void clickEditButton(){
        WebElement editBtn= wait.until(ExpectedConditions.visibilityOfElementLocated(btnEdit));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",editBtn);
        editBtn.click();
    }

    public boolean isEmployeeImageDisplayed(){
        WebElement imgEmp = wait.until(ExpectedConditions.visibilityOfElementLocated(empImg));
        return imgEmp.isDisplayed();
    }

    public void setFirstName(String value){
        WebElement fieldFirstName= wait.until(ExpectedConditions.visibilityOfElementLocated(firstName));
        fieldFirstName.clear();
        fieldFirstName.sendKeys(value);
    }

    public void setMiddleName (String value){
        WebElement fieldMiddleName = wait.until(ExpectedConditions.visibilityOfElementLocated(middleName));
        fieldMiddleName.clear();
        fieldMiddleName.sendKeys(value);
    }

    public void setLastName(String value){
        WebElement fieldLastName =wait.until(ExpectedConditions.visibilityOfElementLocated(lastName));
        fieldLastName.clear();
        fieldLastName.sendKeys(value);
    }

    public void setNickName(String value){
        WebElement labelNickName= wait.until(ExpectedConditions.visibilityOfElementLocated(nickName));
        WebElement fieldNickName= driver.findElement(with(By.tagName("input")).below(labelNickName));

        fieldNickName.clear();
        fieldNickName.sendKeys(value);
    }

    public void setOtherId(String value){
        WebElement labelOtherId= wait.until(ExpectedConditions.visibilityOfElementLocated(otherId));
        WebElement fieldOtherid= driver.findElement(with(By.tagName("input")).below(labelOtherId));

        fieldOtherid.clear();
        fieldOtherid.sendKeys(value);
    }

    public void setDriversLicense(String value){
        WebElement labelDriverLicense= wait.until(ExpectedConditions.visibilityOfElementLocated(driverLicenseNumber));
        WebElement fieldDriverLicense= driver.findElement(with(By.tagName("input")).below(labelDriverLicense));
        fieldDriverLicense.clear();
        fieldDriverLicense.sendKeys(value);
    }

    public void setLicenseExpiredDate(String value ){
        WebElement labelLicenseExpiredDate =wait.until(ExpectedConditions.visibilityOfElementLocated(licenseExpiredDate));
        WebElement fieldLicenseExpiredDate = driver.findElement(with(By.tagName("input")).below(labelLicenseExpiredDate));

        fieldLicenseExpiredDate.clear();
        fieldLicenseExpiredDate.click();
    }



}
