package com.seleniumForFun.ForestRun;

import com.seleniumForFun.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.commonMethods;

import java.util.concurrent.TimeUnit;

public class ForestRun extends BaseTest {
    @BeforeTest
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeClass
    public void setupTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--kiosk");
        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void runner() throws Exception {
        driver.get(prop.getProperty("forestRun"));
        Thread.sleep(10000);
        commonMethods commonMethods = new commonMethods();
        commonMethods.startRecording();

        long start = System.currentTimeMillis();
        long end = start + 180*1000; // 60 seconds * 1000 ms/sec
        while (System.currentTimeMillis() < end)
        {

        }
        commonMethods.stopRecording();
        Thread.sleep(5000);
    }

}
