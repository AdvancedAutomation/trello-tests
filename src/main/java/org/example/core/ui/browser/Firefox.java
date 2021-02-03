package org.example.core.ui.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Class to return the FirefoxDriver for Firefox browser.
 */
public class Firefox implements Browser {

    /**
     * Get the Firefox org.example.core.ui.driver.
     *
     * @return the FirefoxDriver.
     */
    @Override
    public WebDriver getBrowser() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }
}
