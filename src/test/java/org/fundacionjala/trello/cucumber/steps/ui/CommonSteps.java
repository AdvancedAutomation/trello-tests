package org.fundacionjala.trello.cucumber.steps.ui;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.fundacionjala.core.Environment;
import org.fundacionjala.core.ui.Commons;
import org.fundacionjala.core.ui.driver.SharedDriver;
import org.fundacionjala.trello.pages.Navigator;
import org.fundacionjala.trello.pages.common.Login;

/**
 * Common steps.
 */
public class CommonSteps {

    private static final Environment ENVIRONMENT = Environment.getInstance();
    private Login login;
    private Navigator navigator;

    /**
     * Constructor of Common steps.
     *
     * @param sharedDriver sharedDriver.
     * @param login Login.
     * @param navigator Navigator.
     */
    public CommonSteps(final SharedDriver sharedDriver, final Login login, final Navigator navigator) {
        this.login = login;
        this.navigator = navigator;
    }

    /**
     * Given of in page of trello.
     *
     * @param key for start session.
     */
    @Given("I Log in with user {string}")
    public void iLogInWithUser(final String key) {
        String userNameKey = String.format("$['credentials']['%s']['username']", Commons.getUserFromKey(key));
        String passwordKey = String.format("$['credentials']['%s']['password']", Commons.getUserFromKey(key));
        login.loginAs(ENVIRONMENT.getValue(userNameKey), ENVIRONMENT.getValue(passwordKey));
    }

    /**
     * Step to go to the main page.
     */
    @And("I go to the trello page")
    public void iGoToTheTrelloPage() {
        navigator.goToMainPage();
    }
}
