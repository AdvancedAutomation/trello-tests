package org.fundacionjala.trello.cucumber.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.core.Environment;
import org.fundacionjala.trello.pages.BoardCreation;
import org.fundacionjala.trello.pages.BoardFields;
import org.fundacionjala.trello.pages.Boards;
import org.fundacionjala.trello.pages.Home;
import org.fundacionjala.trello.pages.Login;
import org.fundacionjala.trello.pages.SelectedDashBoard;

import java.util.Map;

/**
 * Step definitions for the Dashboard Creation.
 */
public class DeleteBoard {

    private Home home;
    private Boards boards;
    private SelectedDashBoard dashBoard;

//    /**
//     * Given of in page of trello.
//     * @param key for start session
//     */
//    @Given("I Log in with user {string}")
//    public void iLogInWithUser(final String key) {
//        home = new Home();
//        Login login = home.clickInitLink();
//        Environment user = new Environment();
//        user.readJSONUser(key);
//        boards = login.loginAs(user.getUser(), user.getPass());
//    }


}
