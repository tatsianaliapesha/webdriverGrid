package com.globoforce.testautomation.mentoring.webdriver.test.scenarios;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GloboforceMainPageTest extends BaseTest {

    private static final String GF_URL = "https://www.globoforce.com/";
    private final String pageTitle = "Globoforce | Elevate Workplace Culture and Performance | Globoforce";

    @Test
    public void gfMainPageTest() {
        driver.navigate().to(GF_URL);
        Assert.assertEquals(driver.getTitle(), pageTitle, "Incorrect page title!");
    }
}
