package com.globoforce.testautomation.mentoring.webdriver.test.scenarios;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;

    @BeforeClass
    @Parameters({"browser"})
    public void startDriver(String browser) {

        if (browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", ".\\src\\test\\resources\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        if (browser.equals("ie")) {
            System.setProperty("webdriver.ie.driver", ".\\src\\test\\resources\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterClass(alwaysRun = true)
    public void closeDriver() {
        if (driver != null)
            driver.quit();
    }

}
