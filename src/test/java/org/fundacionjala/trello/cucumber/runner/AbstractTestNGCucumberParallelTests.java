package org.fundacionjala.trello.cucumber.runner;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.DataProvider;

public abstract class AbstractTestNGCucumberParallelTests extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}
