package com.seleniumForFun.DeepSea;

import com.seleniumForFun.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DeepSeaTest extends BaseTest {

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
    public void test() throws InterruptedException {
        DeepSea deepSea = new DeepSea(driver);
        driver.get(prop.getProperty("deepSea"));

        List<WebElement> deepSeaObjects = deepSea.selectFish();
        List<WebElement> deepSeaObjectsName = deepSea.nameTheFish();

        while(true){
            ((JavascriptExecutor)driver).executeScript("window.scrollBy(0, 80);", "");
        }
    }
}
