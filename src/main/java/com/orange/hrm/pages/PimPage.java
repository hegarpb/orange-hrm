package com.orange.hrm.pages;

import java.time.Duration;
import java.util.List;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PimPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By menuAddEMployeeEle = By.xpath("//a[normalize-space()='Add Employee']");
    private By pagePim = By.xpath("//span[normalize-space()='PIM']");
    private By empName = By.xpath("//label[normalize-space()='Employee Name']");
    private By btnSearch = By.xpath("//button[normalize-space()='Search']");
    private By btnEdit = By.xpath("//i[@class='oxd-icon bi-pencil-fill']");
    private By empImg = By.xpath("//img[@class='employee-image']");
    private By firstName = By.cssSelector("input[placeholder='First Name']");
    private By middleName = By.xpath("//input[@placeholder='Middle Name']");
    private By lastName = By.xpath("//input[@placeholder='Last Name']");
    private By nickName = By.xpath("//label[normalize-space()='Nickname']");
    private By otherId = By.xpath("//label[normalize-space()='Other Id']");
    private By employeeId = By.xpath("//label[normalize-space()='Employee Id']");
    private By driverLicenseNumber = By.xpath("//label[normalize-space()=\"Driver's License Number\"]");
    private By licenseExpiredDateEle = By.xpath("(//input[@placeholder='yyyy-dd-mm'])[1]");
    private By ssnNumber = By.xpath("//label[normalize-space()='SSN Number']");
    private By sinNumber = By.xpath("//label[normalize-space()='SIN Number']");
    private By drpdNationalityEle = By.xpath("(//div[@class='oxd-select-text oxd-select-text--active'])[1]");
    private By drpdMaritalStatusEle = By.xpath("(//div[@class='oxd-select-text oxd-select-text--active'])[2]");
    private By drpdBloodTypeEle = By.xpath("(//div[@class='oxd-select-text oxd-select-text--active'])[3]");
    private By dateOfBirthEle = By.xpath("(//input[@placeholder='yyyy-dd-mm'])[2]");
    private By saveBtn = By.xpath("//button[normalize-space()='Save']");
    private By btnUpload = By
            .xpath("//button[@class='oxd-icon-button oxd-icon-button--solid-main employee-image-action']");
    private By btnSavePersonalDetail = By.xpath(
            "//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//button[@type='submit'][normalize-space()='Save']");
    private By btnSaveCustomFields = By
            .xpath("//div[@class='orangehrm-custom-fields']//button[@type='submit'][normalize-space()='Save']");
    private By popUpMsg = By.xpath("//p[contains(@class,'oxd-toast-message')]");
    private By toastMessage = By
            .xpath("//div[contains(@class,'oxd-toast-content')]//p[contains(@class,'oxd-text--toast-message')]");

    private By genderEle(String value) {
        return By.xpath("//label[contains(normalize-space(.),'" + value + "')]");
    }

    public PimPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateToPimPage() {
        WebElement pimPage = wait.until(ExpectedConditions.elementToBeClickable(pagePim));
        pimPage.click();
    }

    public void inputEmployeeName(String value) {
        WebElement labelEmpName = wait.until(ExpectedConditions.visibilityOfElementLocated(empName));
        WebElement inputEmpName = driver.findElement(with(By.tagName("input")).below(labelEmpName));
        inputEmpName.clear();
        inputEmpName.sendKeys(value);
    }

    public void clickAddEmployeMenu() {
        WebElement menuAddEmployee = wait.until(ExpectedConditions.elementToBeClickable(menuAddEMployeeEle));
        menuAddEmployee.click();
    }

    public void clickSearchBtn() {
        WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(btnSearch));
        searchBtn.click();
    }

    public void clickEditButton() {
        WebElement editBtn = wait.until(ExpectedConditions.elementToBeClickable(btnEdit));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", editBtn);
        wait.until(ExpectedConditions.elementToBeClickable(btnEdit));
        editBtn.click();
    }

    public void clickSaveAddEmployee() {
        WebElement save = wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
        save.click();
    }

    public void clickSavePersonalDetailBtn() {
        WebElement btnSave = wait.until(ExpectedConditions.elementToBeClickable(btnSavePersonalDetail));
        btnSave.click();
    }

    public void clickSaveCustomFieldBtn() {
        WebElement btnSaveCstm = wait.until(ExpectedConditions.elementToBeClickable(btnSaveCustomFields));
        btnSaveCstm.click();
    }

    public boolean isEmployeeImageDisplayed() {
        WebElement imgEmp = wait.until(ExpectedConditions.visibilityOfElementLocated(empImg));
        return imgEmp.isDisplayed();
    }

    public void setFirstName(String value) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.cssSelector("div.oxd-form-loader")));
        WebElement fieldFirstName = wait.until(ExpectedConditions.elementToBeClickable(firstName));
        fieldFirstName.click();
        fieldFirstName.sendKeys(Keys.chord(Keys.CONTROL, "a")); // select all
        fieldFirstName.sendKeys(Keys.DELETE); // delete
        fieldFirstName.sendKeys(value); // type new value
    }

    public void setMiddleName(String value) {
        WebElement fieldMiddleName = wait.until(ExpectedConditions.elementToBeClickable(middleName));
        fieldMiddleName.click();
        fieldMiddleName.sendKeys(Keys.chord(Keys.CONTROL, "a")); // select all
        fieldMiddleName.sendKeys(Keys.DELETE); // delete
        fieldMiddleName.sendKeys(value); // type new value
    }

    public void setLastName(String value) {
        WebElement fieldLastName = wait.until(ExpectedConditions.elementToBeClickable(lastName));

        fieldLastName.click();
        fieldLastName.sendKeys(Keys.chord(Keys.CONTROL, "a")); // select all
        fieldLastName.sendKeys(Keys.DELETE); // delete
        fieldLastName.sendKeys(value);
    }

    public void setNickName(String value) {
        WebElement labelNickName = wait.until(ExpectedConditions.visibilityOfElementLocated(nickName));
        WebElement fieldNickName = driver.findElement(with(By.tagName("input")).below(labelNickName));

        fieldNickName.clear();
        fieldNickName.sendKeys(value);
    }

    public void setEmployeeId(String value) {
        WebElement labelEmployeeId = wait.until(ExpectedConditions.visibilityOfElementLocated(employeeId));
        WebElement fieldEmployeeId = driver.findElement(with(By.tagName("input")).below(labelEmployeeId));

        fieldEmployeeId.click();
        fieldEmployeeId.sendKeys(Keys.chord(Keys.CONTROL, "a")); // select all
        fieldEmployeeId.sendKeys(Keys.DELETE); // delete
        fieldEmployeeId.sendKeys(value);

    }

    public void setOtherId(String value) {
        WebElement labelOtherId = wait.until(ExpectedConditions.visibilityOfElementLocated(otherId));
        WebElement fieldOtherid = driver.findElement(with(By.tagName("input")).below(labelOtherId));

        fieldOtherid.click();
        fieldOtherid.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        fieldOtherid.sendKeys(Keys.DELETE);
        fieldOtherid.sendKeys(value);
    }

    public void setDriversLicense(String value) {
        WebElement labelDriverLicense = wait.until(ExpectedConditions.visibilityOfElementLocated(driverLicenseNumber));
        WebElement fieldDriverLicense = driver.findElement(with(By.tagName("input")).below(labelDriverLicense));
        fieldDriverLicense.click();
        fieldDriverLicense.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        fieldDriverLicense.sendKeys(Keys.DELETE);
        fieldDriverLicense.sendKeys(value);
    }

    public void setLicenseExpiredDate(String value) {
        WebElement licenseExpiredDate = wait
                .until(ExpectedConditions.elementToBeClickable(licenseExpiredDateEle));
        licenseExpiredDate.click();
        licenseExpiredDate.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        licenseExpiredDate.sendKeys(Keys.DELETE);
        licenseExpiredDate.sendKeys(value);
    }

    public void setSsnNumber(String value) {
        WebElement labelSsnNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(ssnNumber));
        WebElement fieldSsnNumber = driver.findElement(with(By.tagName("input")).below(labelSsnNumber));

        fieldSsnNumber.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        fieldSsnNumber.sendKeys(Keys.DELETE);
        fieldSsnNumber.sendKeys(value);
    }

    public void setSinNumber(String value) {
        WebElement labelSinNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(sinNumber));
        WebElement fieldSinNumber = driver.findElement(with(By.tagName("input")).below(labelSinNumber));

        fieldSinNumber.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        fieldSinNumber.sendKeys(Keys.DELETE);
        fieldSinNumber.sendKeys(value);
    }

    public void setNationality(String value) {
        WebElement drpdNationality = wait.until(ExpectedConditions.elementToBeClickable(drpdNationalityEle));
        drpdNationality.click();

        List<WebElement> options = wait
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.oxd-select-option")));

        for (WebElement option : options) {
            if (option.getText().equalsIgnoreCase(value)) {
                option.click();
                break;
            }
        }

    }

    public void setMaritalStatus(String value) {
        WebElement drpdMaritalStatus = wait.until(ExpectedConditions.elementToBeClickable(drpdMaritalStatusEle));
        drpdMaritalStatus.click();

        List<WebElement> options = wait
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.oxd-select-option")));
        for (WebElement option : options) {
            if (option.getText().equalsIgnoreCase(value)) {
                option.click();
                break;
            }
        }
    }

    public void setDateOfBirth(String value) {
        WebElement dateObBirth = wait.until(ExpectedConditions.elementToBeClickable(dateOfBirthEle));
        dateObBirth.click();

        dateObBirth.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        dateObBirth.sendKeys(Keys.DELETE);
        dateObBirth.sendKeys(value);
    }

    public String msgPopup() {
        WebElement toast = wait.until(ExpectedConditions.presenceOfElementLocated(popUpMsg));
        return toast.getText().trim();
    }

    public void selectGender(String value) {
        WebElement gender = wait.until(ExpectedConditions.elementToBeClickable(genderEle(value)));
        if (!gender.isSelected()) {
            gender.click();
        }
    }

    public void selectBloodType(String value) {
        WebElement bloodType = wait.until(ExpectedConditions.elementToBeClickable(drpdBloodTypeEle));
        bloodType.click();

        List<WebElement> options = wait
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.oxd-select-option")));
        for (WebElement option : options) {
            if (option.getText().equalsIgnoreCase(value)) {
                option.click();
                break;
            }
        }
    }

    public String waitForToast() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement toast = wait.until(
                ExpectedConditions.visibilityOfElementLocated(toastMessage));

        String text = toast.getText().trim();
        System.out.println("DEBUG Toast text = [" + text + "]");
        return text;
    }

    public void uploadPhotoWithRobot() throws AWTException {
        WebElement uploadBtn = wait.until(ExpectedConditions.elementToBeClickable(
                btnUpload));
        uploadBtn.click();

        String filePath = "C:\\Users\\LENOVO\\OneDrive\\Pictures\\hsh\\user_219988.png";

        StringSelection selection = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

        Robot robot = new Robot();
        robot.delay(1000);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        robot.delay(500);

        // Tekan ENTER (confirm pilih file)
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

}
