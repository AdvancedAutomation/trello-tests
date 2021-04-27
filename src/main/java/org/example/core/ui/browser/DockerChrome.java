package org.example.core.ui.browser;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;

import org.example.core.Environment;

/**
 * DockerChrome class.
 */
public class DockerChrome extends RemoteBrowser {

    public DockerChrome() {
        super(Environment.getInstance().getValue("docker.remoteServer"));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    MutableCapabilities buildCapabilities() {
        return new ChromeOptions();
    }
}
