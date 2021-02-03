package org.example.core.ui.driver;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;

public final class DriverFactory {

    private static final ThreadLocal<WebDriver> DRIVERS = new ThreadLocal<>();

    // To quit the drivers and browsers at the end only.
    private static final List<WebDriver> STORED_DRIVERS = new ArrayList<>();

    static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> STORED_DRIVERS.forEach(WebDriver::quit)));
    }

    private DriverFactory() {
    }

    public static WebDriver getDriver() {
        return DRIVERS.get();
    }

    /**
     * Adding driver.
     *
     * @param driver Webdriver.
     */
    public static void addDriver(final WebDriver driver) {
        STORED_DRIVERS.add(driver);
        DRIVERS.set(driver);
    }

    public static void unload() {
        DRIVERS.remove();
    }
}
