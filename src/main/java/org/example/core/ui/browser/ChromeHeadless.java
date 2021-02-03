package org.example.core.ui.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Class to return the ChromeDriver for Chrome browser.
 */
public class ChromeHeadless implements Browser {
    /**
     * Get the Chrome org.example.core.ui.driver.
     *
     * @return the ChromeDriver.
     */
    @Override
    public WebDriver getBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        options.addArguments("disable-gpu");
        return new ChromeDriver(options);
    }
}
