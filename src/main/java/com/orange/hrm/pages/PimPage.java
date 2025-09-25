package com.orange.hrm.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.gl.E;

public class PimPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By pagePim =By.xpath("//span[normalize-space()='PIM']");
    private By empName = By.xpath("//label[text()='Employee Name']/ancestor::div[contains(@class,'oxd-input-group')]//input");
    private By btnSearch= By.xpath("//button[normalize-space()='Search']");
    private By btnEdit= By.xpath("//i[@class='oxd-icon bi-pencil-fill']");
    private By empImg = By.xpath("//img[@class='employee-image']");

    public PimPage(WebDriver driver){
        this.driver=driver;
        this.wait= new WebDriverWait(driver,Duration.ofSeconds(5));
    }
    
    public void navigateToPimPage(){
        WebElement pimPage= wait.until(ExpectedConditions.elementToBeClickable(pagePim));
        pimPage.click();
    }

    public void inputEmployeeName(String value){
        WebElement inputEmpName= wait.until(ExpectedConditions.visibilityOfElementLocated(empName));
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
}
