package org.fundacionjala.trello.cucumber.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.fundacionjala.core.CleanData;
import org.fundacionjala.core.ui.driver.DriverManager;

/**
 * Class which runs all features.
 */
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"org.fundacionjala.trello.cucumber"},
        plugin = {"pretty"}
)
public class RunCucumberTest extends AbstractTestNGCucumberTests {

    /**
     * this method execute before the tests.
     */
    @BeforeTest
    public void open() {
        // Implement.
    }

    /**
     * this method close the browser after the features finish.
     */
    @AfterTest
    public void close() {
        CleanData.cleanAllTeams("owner1");
        CleanData.cleanAllBoards("owner1");
        DriverManager.getInstance().getDriver().quit();
    }
}
