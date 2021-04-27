package org.example.core.ui.browser;

import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * This class allows to establish the connection in the remote browser through SauceLabs.
 */
public class SauceLabs extends RemoteBrowser {

    private static final String URL = String.format("http://%s:%s@ondemand.saucelabs.com:80/wd/hub",
            ENVIRONMENT.getValue("$['saucelabs']['user']"),
            ENVIRONMENT.getValue("$['saucelabs']['key']"));
    private static final String BROWSER_NAME = "browserName";
    private static final String PLATFORM = "platform";
    private static final String BROWSER_VERSION = "version";

    /**
     * This is the constructor.
     */
    public SauceLabs() {
        super(URL);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DesiredCapabilities buildCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(BROWSER_NAME, ENVIRONMENT.getValue("$['saucelabs']['browserName']"));
        capabilities.setCapability(PLATFORM, ENVIRONMENT.getValue("$['saucelabs']['platform']"));
        capabilities.setCapability(BROWSER_VERSION, ENVIRONMENT.getValue("$['saucelabs']['version']"));
        return capabilities;
    }
}
