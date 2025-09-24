package com.orange.hrm;

import com.orange.hrm.utils.DriverUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks {

    private static WebDriver driver;

    // Metode untuk memulai driver dan login. Gunakan @Before di sini.
    @Before
    public void setUp() {
        // Inisialisasi driver
        driver = DriverUtil.getDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
    }

    // Metode untuk menghentikan driver dan mengambil screenshot. Gunakan @After di sini.
    @After
    public void tearDown(Scenario scenario) {
        try {
            if (driver != null && scenario.isFailed()) {
                // Ambil screenshot hanya jika skenario gagal
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                // Attach ke report Cucumber
                scenario.attach(screenshot, "image/png", scenario.getName());
            }
        } catch (Exception e) {
            System.out.println("Gagal mengambil screenshot: " + e.getMessage());
        } finally {
            // Tutup driver
            if (driver != null) {
                DriverUtil.quitDriver();
            }
        }
    }

    // Metode static untuk menyediakan akses driver ke kelas Step Definitions
    public static WebDriver getDriver() {
        return driver;
    }
}