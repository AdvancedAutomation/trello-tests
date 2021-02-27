package org.example.trello.ui.cucumber.steps;

import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import org.example.core.Environment;
import org.example.core.ui.Commons;
import org.example.trello.ui.pages.Navigator;
import org.example.trello.ui.pages.board.BoardFields;
import org.example.trello.ui.pages.common.Login;
import org.example.trello.ui.pages.team.TeamFields;

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
     * @param login Login.
     * @param navigator Navigator.
     */
    public CommonSteps(final Login login, final Navigator navigator) {
        this.login = login;
        this.navigator = navigator;
    }

    @DataTableType
    public BoardFields boardMap(final String boardField) {
        return BoardFields.valueOf(boardField.toUpperCase());
    }

    @DataTableType
    public TeamFields teamMap(final String teamField) {
        return TeamFields.valueOf(teamField.toUpperCase());
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
