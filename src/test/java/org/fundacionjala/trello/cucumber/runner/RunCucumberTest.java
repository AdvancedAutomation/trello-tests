package org.fundacionjala.trello.cucumber.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.fundacionjala.core.ui.DriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


/**
 * Class which runs all features.
 */
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"org.fundacionjala.trello.cucumber"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt"
        })
public class RunCucumberTest extends AbstractTestNGCucumberTests {


    /**
     * this method execute before the tests.
     */
    @BeforeClass
    public void open() {
        // implement
    }

    /**
     * this method close the browser after the features finish.
     */
    @AfterClass
    public void close() {

        System.out.println("##############################################");

        DriverManager.getInstance().getDriver().close();
        //@CleanAllBoards
    }
}
