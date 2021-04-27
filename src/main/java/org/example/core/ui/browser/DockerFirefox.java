package org.example.core.ui.browser;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.firefox.FirefoxOptions;

import org.example.core.Environment;

/**
 * DockerFirefox class.
 */
public class DockerFirefox extends RemoteBrowser {

    public DockerFirefox() {
        super(Environment.getInstance().getValue("docker.remoteServer"));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    MutableCapabilities buildCapabilities() {
        return new FirefoxOptions();
    }
}
