package com.example.utils;

import com.example.page.CraigslistMainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Collections;

public abstract class BaseTest {
    protected static WebDriver driver;
    protected CraigslistMainPage welcomePage;

    @BeforeMethod
    public void preCondition() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = getChromeOptions();

        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("https://miami.craigslist.org/");

        welcomePage = new CraigslistMainPage(driver);
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions optionsChrome = new ChromeOptions();
        optionsChrome.addArguments("start-maximized");
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
