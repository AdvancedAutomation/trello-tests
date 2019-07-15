package org.fundacionjala.trello.cucumber.hooks;

import cucumber.api.java.Before;
import org.fundacionjala.core.ui.driver.DriverManager;

public class CommonHooks {

    @Before
    public void setUp() {
        DriverManager.getInstance().getDriver().navigate().refresh();
    }
}
