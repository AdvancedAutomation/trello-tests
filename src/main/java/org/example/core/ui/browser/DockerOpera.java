package org.example.core.ui.browser;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.opera.OperaOptions;

import org.example.core.Environment;

/**
 * DockerOpera class.
 */
public class DockerOpera extends RemoteBrowser {

    public DockerOpera() {
        super(Environment.getInstance().getValue("docker.remoteServer"));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    MutableCapabilities buildCapabilities() {
        return new OperaOptions();
    }
}
