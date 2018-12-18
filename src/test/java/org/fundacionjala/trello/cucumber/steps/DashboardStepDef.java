package org.fundacionjala.trello.cucumber.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.core.Environment;
import org.fundacionjala.core.ui.CommonActions;
import org.fundacionjala.trello.pages.BoardCreation;
import org.fundacionjala.trello.pages.BoardFields;
import org.fundacionjala.trello.pages.Boards;
import org.fundacionjala.trello.pages.Home;
import org.fundacionjala.trello.pages.Login;
import org.fundacionjala.trello.pages.SelectedBoard;
import org.junit.Assert;

import java.util.Map;

/**
 * Step definitions for the Dashboard Creation.
 */
public class DashboardStepDef {

    private Home home;
    private Boards boards;
    private SelectedBoard boardMain;
    private BoardCreation newBoard;

    /**
     * Given of in page of trello.
     */
    @Given("I am on the Home page Trello")
    public void onTrello() {
        home = new Home();
    }

    /**
     * When of Log a user.
     *
     * @param key int for select a user.
     */
    @When("I Log with user {string}")
    public void logIn(final String key) {
        Login login = home.clickInitLink();
        Environment user = new Environment();
        CommonActions decrypt = new CommonActions();
        user.readJSONUser(decrypt.getUserFromKey(key));
        boards = login.loginAs(user.getUser(), user.getPass());
    }

    /**
     * Cretion of a dashboar with a specs.
     *
     * @param dataTable input String.
     */
    @When("I create a board with a:")
    public void iCreateABoardWithA(final Map<BoardFields, String> dataTable) {
        newBoard = boards.clickAddBoard();
        boardMain = newBoard.createNewBoard(dataTable);
    }

    /**
     * Dashboard page.
     */
    @Then("I should see the board")
    public void seeBoard() {
        Assert.assertEquals(newBoard.getTitleString(), boardMain.getName());
        if (newBoard.getPrivacyString() != null) {
            Assert.assertEquals(newBoard.getPrivacyString(), boardMain.getPrivacy());
        }
        home.closeDriver();
    }
}
