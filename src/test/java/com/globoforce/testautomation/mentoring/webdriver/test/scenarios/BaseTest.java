package com.globoforce.testautomation.mentoring.webdriver.test.scenarios;


import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    protected WebDriver driver;
    private final String URL = "http://10.6.126.177:4444/wd/hub";

    @BeforeClass
    public void startRemoteDriver() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        String browserName = System.getProperty("browser");
        cap.setBrowserName(browserName);
        String platform = System.getProperty("platform");
        cap.setPlatform(Platform.fromString(platform));
        driver = new RemoteWebDriver(new URL(this.URL), cap);
    }

    @AfterClass
    public void quiteDriver(){
        driver.quit();
    }

}
