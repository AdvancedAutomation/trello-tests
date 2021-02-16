package org.example.core.ui.browser;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.example.core.Environment;

/**
 * DockerChrome class.
 */
public class DockerChrome implements Browser {
    private static final Logger LOGGER = LogManager.getLogger(DockerChrome.class.getName());

    /**
     * {@inheritDoc}
     */
    @Override
    public WebDriver getBrowser() {
        WebDriver driver = null;
        try {
            URL remoteAddress = new URL(Environment.getInstance().getValue("$['docker']['remoteServer']"));
            driver = new RemoteWebDriver(remoteAddress, new ChromeOptions());
        } catch (MalformedURLException e) {
            LOGGER.error("URL bad created:", e);
        }
        return driver;
    }
}
