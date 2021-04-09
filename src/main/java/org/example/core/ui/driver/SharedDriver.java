package org.example.core.ui.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.example.core.Environment;

public class SharedDriver {

    public SharedDriver() {
        WebDriver driverSession = DriverFactory.getDriver();
        if (driverSession == null || ((RemoteWebDriver) driverSession).getSessionId() == null) {
            String browser = Environment.getInstance().getValue("local.browser").toUpperCase();
            WebDriver driver = BrowserFactory.getDriverManager(DriverType.valueOf(browser));
            DriverFactory.addDriver(driver);
        }
    }
}
