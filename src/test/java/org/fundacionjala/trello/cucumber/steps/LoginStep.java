package org.fundacionjala.trello.cucumber.steps;

import cucumber.api.java.en.Given;

import org.fundacionjala.core.Environment;
import org.fundacionjala.core.ui.Commons;
import org.fundacionjala.trello.pages.Home;
import org.fundacionjala.trello.pages.Login;



/**
 * Step definitions for the board Creation.
 */
public class LoginStep {

    public static final Environment ENVIRONMENT = Environment.getInstance();
    private Home home;

    /**
     * Given of in page of trello.
     */
    @Given("I am on the Home page Trello")
    public void onTrello() {
        home = new Home();
    }

    /**
     * Given of in page of trello.
     * @param key for start session.
     */
    @Given("I Log in with user {string}")
    public void iLogInWithUser(final String key) {
        home = new Home();
        Login login = home.clickInitLink();
        String userNameKey = String.format("$['credentials']['%s']['username']", Commons.getUserFromKey(key));
        String passwordKey = String.format("$['credentials']['%s']['password']", Commons.getUserFromKey(key));
        login.loginAs(ENVIRONMENT.getValue(userNameKey),
                ENVIRONMENT.getValue(passwordKey));
    }
}
