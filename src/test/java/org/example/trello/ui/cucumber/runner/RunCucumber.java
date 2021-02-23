package org.example.trello.ui.cucumber.runner;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.example.core.Environment;
import org.example.core.ui.driver.BrowserFactory;
import org.example.core.ui.driver.DriverFactory;
import org.example.core.ui.driver.DriverType;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

/**
 * Class which runs all features.
 */
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"org.example.trello.ui.cucumber"},
        plugin = {"pretty"},
        tags = "@jc"
)
public class RunCucumber extends AbstractTestNGCucumberTests {


    /**
     * gets value from testng.xml for cross-browser execution.
     */
//    @BeforeClass
//    @Parameters("browser")
//    public void setupBrowser(String browser){
//        Environment.getInstance().setBrowser(browser);
//    }

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

    @After
    public void markBrowserStackTestStatus(Scenario scenario) {
        if("BROWSER_STACK".equals(Environment.getInstance().getValue("$['local']['browser']"))){
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor)DriverFactory.getDriver();
            if (scenario.isFailed()) {
                javascriptExecutor.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \""+"failed"+"\", \"reason\": \""+"Test failed."+"\"}}");
            } else {
                javascriptExecutor.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \""+"passed"+"\", \"reason\": \""+"Test passed."+"\"}}");
            }
        }
    }
}
