package org.example.core.ui.browser;

import org.openqa.selenium.WebDriver;

@FunctionalInterface
public interface Browser {
    /**
     * @return get browser webdriver.
     */
    WebDriver getBrowser();
}
