package org.example.trello.ui.cucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

/**
 * Class which runs all features.
 */
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"org.example.trello.ui.cucumber"},
        plugin = {"pretty"},
        tags = "@bvt"
)
public class RunCucumber extends AbstractTestNGCucumberTests {

    /**
     * this method execute before the tests.
     */
    @BeforeTest
    public void open() {
        // Implement.
        System.setProperty("dataproviderthreadcount", "2");
    }

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    /**
     * this method close the browser after the features finish.
     */
    @AfterTest
    public void close() {
        // Implement.
    }
}
