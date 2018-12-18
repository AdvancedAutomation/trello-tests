package org.fundacionjala.trello.cucumber.steps;

import cucumber.api.java.en.Given;

import org.fundacionjala.core.Environment;
import org.fundacionjala.core.ui.CommonActions;
import org.fundacionjala.trello.pages.Home;
import org.fundacionjala.trello.pages.Login;



/**
 * Step definitions for the board Creation.
 */
public class LoginStep {

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
        Environment user = new Environment();
        CommonActions decrypt = new CommonActions();
        user.readJSONUser(decrypt.getUserFromKey(key));
        login.loginAs(user.getUser(), user.getPass());
    }
}
