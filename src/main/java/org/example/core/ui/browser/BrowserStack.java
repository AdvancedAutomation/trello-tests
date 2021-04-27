package org.example.core.ui.browser;

import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * This class allows to establish the connection in the remote browser through Browser Stack.
 */
public class BrowserStack extends RemoteBrowser {
    private static final String URL = String.format("http://%s:%s@hub-cloud.browserstack.com/wd/hub",
            ENVIRONMENT.getValue("$['browserstack']['user']"),
            ENVIRONMENT.getValue("$['browserstack']['key']"));
    private static final String BROWSER = "browser";
    private static final String BROWSER_VERSION = "browser_version";
    private static final String OS = "os";
    private static final String OS_VERSION = "os_version";

    /**
     * This is the constructor.
     */
    public BrowserStack() {
        super(URL);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DesiredCapabilities buildCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(OS, ENVIRONMENT.getValue("$['browserstack']['os']"));
        capabilities.setCapability(OS_VERSION, ENVIRONMENT.getValue("$['browserstack']['os_version']"));
        capabilities.setCapability(BROWSER, ENVIRONMENT.getValue("$['browserstack']['browser']"));
        capabilities.setCapability(BROWSER_VERSION, ENVIRONMENT.getValue("$['browserstack']['browser_version']"));
        return capabilities;
    }
}
