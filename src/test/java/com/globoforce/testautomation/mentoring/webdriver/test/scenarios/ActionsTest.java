package com.globoforce.testautomation.mentoring.webdriver.test.scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class ActionsTest extends BaseTest {

    private static final String SERVER_URL = "https://staging-sandbox0.corp.globoforce.com/iaf-config-app/";
    private static final String AWARD_PROGRAMS_PATH = "manageAwardProgramsOpen?client=5021&menuid=6_1";

    @BeforeClass(description = "login to config app")
    @Parameters({"username", "password"})
    public void loginToConfigApp(String username, String password) {
        driver.navigate().to(SERVER_URL);
        driver.findElement(By.name("j_username")).sendKeys(username);
        driver.findElement(By.name("j_password")).sendKeys(password);
        driver.findElement(By.className("button")).click();
    }

    @BeforeClass(dependsOnMethods = "loginToConfigApp", description = "navigate to award programs menu")
    public void navigateToAwardProgramsMenu() {
        driver.navigate().to(SERVER_URL + AWARD_PROGRAMS_PATH);
    }

    @Test(description = "swap the last item to the first position")
    public void actionTest() throws Exception {
        WebElement awardReasonsLink = driver.findElement(By.id("manageReasonsLink19975"));
        //open award reasons list for the program.
        awardReasonsLink.click();
        List<WebElement> items = driver.findElements(By.xpath("//ul[@id='all_items']/li"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(items.get(items.size() - 1), items.get(0)).build().perform();
    }

}
