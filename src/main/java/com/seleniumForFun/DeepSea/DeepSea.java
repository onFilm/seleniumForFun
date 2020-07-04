package com.seleniumForFun.DeepSea;

import com.seleniumForFun.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DeepSea extends BasePage {

    public DeepSea(final WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver driver;
    By imageOfFish = By.xpath("//div[contains(@class, 'sc-fzplWN')]//img");
    By nameOfFish= By.xpath("//div[contains(@class, 'sc-fzplWN')]//div");

    public List<WebElement> selectFish() {
        return driver.findElements(imageOfFish);
    }

    public List<WebElement> nameTheFish() {
        return driver.findElements(nameOfFish);
    }
}
