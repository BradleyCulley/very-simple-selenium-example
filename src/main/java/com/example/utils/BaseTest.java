package com.example.utils;

import com.example.page.PopupDemoPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Collections;

public abstract class BaseTest {
    protected static WebDriver driver;
    protected PopupDemoPage welcomePage;

    @BeforeMethod
    public void preCondition() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = getChromeOptions();

        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        String url = "file://" + System.getProperty("user.dir") + "/test.html";
        driver.get(url);
        welcomePage = new PopupDemoPage(driver);
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions optionsChrome = new ChromeOptions();
        optionsChrome.addArguments("start-maximized");
        optionsChrome.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.IGNORE);
        optionsChrome.setCapability("chrome.switches",
                Collections.singletonList("--ignore-certificate-errors,--web-security=false,--ssl-protocol=any,--ignore-ssl-errors=true"));
        optionsChrome.setAcceptInsecureCerts(true);
        //        optionsChrome.setHeadless(true); // comment/uncomment for headless/non-headless

        return optionsChrome;
    }

    @AfterMethod
    public void postCondition(){
        driver.quit();
    }
}
