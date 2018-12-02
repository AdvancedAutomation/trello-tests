package org.fundacionjala.core.ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Webdriver singleton pattern.
 */
public final class DriverManager {
    private static DriverManager ourInstance = new DriverManager();
    private static final int TIME_OUT_IN_SECONDS = 30;
    private WebDriver driver;
    private WebDriverWait wait;

    /**
     * Getter of singleton instance.
     * @return DriverManager object .
     */
    public static DriverManager getInstance() {
        return ourInstance;
    }

    /**
     * Constructor of class.
     */
    private DriverManager() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);
    }

    /**
     * Gets of WebDriver.
     * @return WebDriver object.
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Gets of WebDriverWait.
     * @return WebDriverWait object
     */
    public WebDriverWait getWait() {
        return wait;
    }

}
