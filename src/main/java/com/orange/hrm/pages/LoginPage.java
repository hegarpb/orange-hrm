package com.orange.hrm.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By username = By.name("username");
    private By password =By.name("password");
    private By btnLogin=By.cssSelector("button[type='submit']");
    private By errMessage = By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']");
    private By validationFiled= By.xpath("//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']");

    public LoginPage(WebDriver driver){
        this.driver=driver;
        this.wait = new WebDriverWait(driver,Duration.ofSeconds(5));
    }

    public void setUsername(String value){
        WebElement usernameElement= wait.until(ExpectedConditions.visibilityOfElementLocated(username));
        usernameElement.sendKeys(value);
    }

    public void setPassword(String value){
        WebElement passwordElement=wait.until(ExpectedConditions.visibilityOfElementLocated(password));
        passwordElement.sendKeys(value);
    }

    public void clickButtonLogin(){
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(btnLogin));
        button.click();
    }

    public void performLogin(){
        setUsername("Admin");
        setPassword("admin123");
        clickButtonLogin();
    }

    public void performLogin(String username, String password){
        setUsername(username);
        setPassword(password);
    }

    public String getErrMessage(){
        WebElement errMsg= wait.until(ExpectedConditions.visibilityOfElementLocated(errMessage));
        return errMsg.getText();
    }

    public String getValidationField(){
        WebElement validateField=wait.until(ExpectedConditions.visibilityOfElementLocated(validationFiled));
        return validateField.getText();

    }

    public String getCurrentUrl(){
        wait.until(ExpectedConditions.urlToBe("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"));
        return driver.getCurrentUrl();

    }

    
}
