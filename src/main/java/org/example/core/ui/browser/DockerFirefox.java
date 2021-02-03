package org.example.core.ui.browser;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.core.Environment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * DockerFirefox class.
 */
public class DockerFirefox implements Browser {
    private static final Logger LOGGER = LogManager.getLogger(DockerFirefox.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public WebDriver getBrowser() {
        WebDriver driver = null;
        try {
            URL remoteAddress = new URL(Environment.getInstance().getValue("$['docker']['remoteServer']"));
            driver = new RemoteWebDriver(remoteAddress, new FirefoxOptions());
        } catch (MalformedURLException e) {
            LOGGER.error("URL bad created:", e);
        }
        return driver;
    }
}
