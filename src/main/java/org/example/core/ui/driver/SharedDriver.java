package org.example.core.ui.driver;

import org.example.core.Environment;
import org.openqa.selenium.WebDriver;

public class SharedDriver {

    public SharedDriver() {
        if (DriverFactory.getDriver() == null) {
            String browser = Environment.getInstance().getValue("$['local']['browser']").toUpperCase();
            WebDriver driver = BrowserFactory.getDriverManager(DriverType.valueOf(browser));
            driver.manage().window().maximize();
            DriverFactory.addDriver(driver);
        }
    }
}
