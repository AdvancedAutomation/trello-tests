package org.fundacionjala.trello.cucumber.hooks;

import cucumber.api.java.Before;
import org.fundacionjala.core.ui.driver.DriverFactory;
import org.fundacionjala.core.ui.driver.SharedDriver;

public class CommonHooks {

    public CommonHooks(final SharedDriver sharedDriver) {

    }

    @Before
    public void setUp() {
        DriverFactory.getDriver().navigate().refresh();
    }
}
