package com.seleniumForFun.DoodleCricketTest;

import com.seleniumForFun.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import utilities.commonMethods;

import java.util.concurrent.TimeUnit;

public class DoodleCricketTest extends BaseTest {

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setupTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--kiosk");
        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void runner() throws Exception {
        driver.get(prop.getProperty("doodleCricket"));
        Thread.sleep(10000);
        commonMethods commonMethods = new commonMethods();
        commonMethods.startRecording();
        Actions act= new Actions(driver);

        for(int i=0;i<=500;i++){
            act.moveToElement(driver.findElement(By.tagName("body")),350,350).click().build().perform();
        }
        commonMethods.stopRecording();
    }

}
