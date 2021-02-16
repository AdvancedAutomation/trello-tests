package org.example.trello.ui.cucumber.hooks;

import io.cucumber.java.Before;

import org.example.core.ui.driver.DriverFactory;
import org.example.core.ui.driver.SharedDriver;

public class CommonHooks {

    public CommonHooks(final SharedDriver sharedDriver) {

    }

    @Before
    public void setUp() {
        DriverFactory.getDriver().navigate().refresh();
    }
}
