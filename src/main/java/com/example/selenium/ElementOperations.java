package com.example.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementOperations {
    public static void waitForVisible(WebDriver driver, WebElement webElement) {
        int timeWait = 5;
        WebDriverWait explicitWaitByElement = new WebDriverWait(driver, timeWait);
        explicitWaitByElement.until(ExpectedConditions.visibilityOf(webElement));
    }
}
