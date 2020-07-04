package com.seleniumForFun.FindTheInvisibleCowTest;

import com.seleniumForFun.BaseTest;
import com.seleniumForFun.FindTheInvisibleCow.FindTheInvisibleCow;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class FindTheInvisibleCowTest extends BaseTest {

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
    public void runner() throws InterruptedException {
        FindTheInvisibleCow findTheCow = new FindTheInvisibleCow(driver);
        driver.get(prop.getProperty("findTheInvisibleCow"));

        findTheCow.startGame().click();
        Thread.sleep(5000);

        int xCoordinate =0 , yCoordinate =0;

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        System.out.println(width + " -- " +height);

        Actions actions = new Actions(driver);

        for( xCoordinate=1; xCoordinate <= width; xCoordinate = xCoordinate + 10) {
            for (yCoordinate=1; yCoordinate <= 384; yCoordinate = yCoordinate + 10) {
                System.out.println("xCoordinate : "+xCoordinate+" yCoordinate : "+yCoordinate);

                actions.moveToElement(driver.findElement(By.tagName("body")), xCoordinate, yCoordinate);
                actions.click().build().perform();
            }
        }
    }

}
