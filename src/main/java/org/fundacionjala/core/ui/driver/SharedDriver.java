package org.fundacionjala.core.ui.driver;

import org.fundacionjala.core.Environment;
import org.openqa.selenium.WebDriver;

public class SharedDriver {

    public SharedDriver() {
        if (DriverFactory.getDriver() == null) {
            String browser = Environment.getInstance().getValue("$['local']['browser']").toUpperCase();
            WebDriver driver = BrowserFactory.getDriverManager(DriverType.valueOf(browser));
            driver.manage().window().maximize();
            driver.get("https://trello.com/login");
            DriverFactory.addDriver(driver);
        }
    }
}
