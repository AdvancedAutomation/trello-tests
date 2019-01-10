package org.fundacionjala.trello.cucumber.steps.ui;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

import org.fundacionjala.core.Environment;
import org.fundacionjala.core.ui.Commons;
import org.fundacionjala.trello.pages.Navigator;
import org.fundacionjala.trello.pages.common.Login;

/**
 * Common steps.
 */
public class CommonSteps {

    private static final Environment ENVIRONMENT = Environment.getInstance();

    /**
     * Given of in page of trello.
     *
     * @param key for start session.
     */
    @Given("I Log in with user {string}")
    public void iLogInWithUser(final String key) {
        Login login = new Login();
        String userNameKey = String.format("$['credentials']['%s']['username']", Commons.getUserFromKey(key));
        String passwordKey = String.format("$['credentials']['%s']['password']", Commons.getUserFromKey(key));
        login.loginAs(ENVIRONMENT.getValue(userNameKey), ENVIRONMENT.getValue(passwordKey));
    }

    /**
     * Step to go to the main page.
     */
    @And("I go to the trello page")
    public void iGoToTheTrelloPage() {
        Navigator navigator = new Navigator();
        navigator.goMainPage();
    }
}
