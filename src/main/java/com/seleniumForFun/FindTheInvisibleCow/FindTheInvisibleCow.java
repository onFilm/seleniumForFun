package com.seleniumForFun.FindTheInvisibleCow;

import com.seleniumForFun.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FindTheInvisibleCow extends BasePage {

    public FindTheInvisibleCow(final WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver driver;

    By startGame = By.xpath("//button[contains(text(),'Start Game')]");

    public WebElement startGame() {
        return driver.findElement(startGame);
    }
}
