package org.fundacionjala.core.ui.driver;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

import org.openqa.selenium.WebDriver;

import org.fundacionjala.core.ui.browser.Browser;
import org.fundacionjala.core.ui.browser.BrowserStack;
import org.fundacionjala.core.ui.browser.Chrome;
import org.fundacionjala.core.ui.browser.DockerChrome;
import org.fundacionjala.core.ui.browser.DockerFirefox;
import org.fundacionjala.core.ui.browser.Firefox;
import org.fundacionjala.core.ui.browser.SauceLabs;

/**
 * Class created in order to recognize the org.fundacionjala.core.ui.driver type.
 */
public final class DriverFactory {

    private static final Map<DriverType, Supplier<Browser>> BROWSERS = new EnumMap<>(DriverType.class);
    static {
        BROWSERS.put(DriverType.CHROME, Chrome::new);
        BROWSERS.put(DriverType.FIREFOX, Firefox::new);
        BROWSERS.put(DriverType.DOCKER_CHROME, DockerChrome::new);
        BROWSERS.put(DriverType.DOCKER_FIREFOX, DockerFirefox::new);
        BROWSERS.put(DriverType.SAUCE_LABS, SauceLabs::new);
        BROWSERS.put(DriverType.BROWSER_STACK, BrowserStack::new);
    }

    /**
     * Private Constructor for the DriverFactory utility class.
     */
    private DriverFactory() {
    }

    /**
     * Return the WebDriver instance specified by the environment properties.
     *
     * @param driverType Enum value specified from DriverType.
     * @return a WebDriver instance.
     */
    public static WebDriver getDriverManager(final DriverType driverType) {
        return BROWSERS.getOrDefault(driverType, Chrome::new).get().getBrowser();
    }
}
