package org.fundacionjala.trello.cucumber.steps;

import cucumber.api.java.en.Given;

import org.fundacionjala.core.Environment;
import org.fundacionjala.core.ui.Commons;
import org.fundacionjala.trello.pages.Login;



/**
 * Step definitions for the board Creation.
 */
public class LoginStep {

    private Login login;

    /**
     * Given of in page of trello.
     * @param key for start session.
     */
    @Given("I Log in with user {string}")
    public void iLogInWithUser(final String key) {
        login = new Login();
        Environment user = Environment.getInstance(Commons.getUserFromKey(key));
        login.loginAs(user.getUser(), user.getPass());
    }
}
