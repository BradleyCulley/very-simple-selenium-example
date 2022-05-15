package com.example.page;

import com.example.selenium.ElementOperations;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CraigslistMainPage {
    private final WebDriver driver;

    public CraigslistMainPage(WebDriver webDriver){
        this.driver = webDriver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#topban .location-picker-link")
    private WebElement mainHeading;

    public String getTitle() {
        return driver.getTitle();
    }

    public String getMainHeading() {
        ElementOperations.waitForVisible(driver, mainHeading);
        return mainHeading.getText();
    }
}
