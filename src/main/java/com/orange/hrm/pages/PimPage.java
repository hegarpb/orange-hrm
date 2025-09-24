package com.orange.hrm.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PimPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By pagePim=By.xpath("//span[normalize-space()='PIM']");

    public PimPage(WebDriver driver){
        this.driver=driver;
        this.wait= new WebDriverWait(driver,Duration.ofSeconds(5));
    }
    
    
}
