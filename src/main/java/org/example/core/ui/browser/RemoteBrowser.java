package org.example.core.ui.browser;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.example.core.Environment;

/**
 * This abstract class implements methods to use in SauceLabs and Browser Stack connection.
 */
public abstract class RemoteBrowser implements Browser {
    protected static final Environment ENVIRONMENT = Environment.getInstance();
    private final String url;
    private static final Logger LOGGER = LogManager.getLogger(RemoteBrowser.class);

    /**
     * This method buildCapabilities the remote browser.
     *
     * @return MutableCapabilities instance.
     */
    abstract MutableCapabilities buildCapabilities();

    /**
     * This is the constructor.
     *
     * @param url url connection.
     */
    protected RemoteBrowser(final String url) {
        this.url = url;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebDriver getBrowser() {
        WebDriver driver;
        try {
            driver = new RemoteWebDriver(new URL(url), buildCapabilities());
        } catch (MalformedURLException e) {
            LOGGER.error("URL bad created:", e);
            throw new RuntimeException("URL bad created:", e);
        }
        return driver;
    }
}
