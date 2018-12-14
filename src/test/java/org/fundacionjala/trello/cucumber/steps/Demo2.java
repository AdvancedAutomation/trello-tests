package org.fundacionjala.trello.cucumber.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.core.Environment;
import org.fundacionjala.core.ui.CommonActions;
import org.fundacionjala.trello.pages.Boards;
import org.fundacionjala.trello.pages.Login;
import org.fundacionjala.trello.pages.SelectedBoard;
import org.fundacionjala.trello.pages.BoardCreation;
import org.fundacionjala.trello.pages.BoardFields;

import java.util.Map;

/**
 * Step definitions for the Dashboard Creation.
 */
public class Demo2 {

    private Login login;
    private Boards boards;
    private SelectedBoard dashBoard;

    /**
     * Given of in page of trello.
     * @param key for start session
     */
    @Given("I Log in with user {string}")
    public void iLogInWithUser(final String key) {
        login = new Login();
        Environment user = new Environment();
        CommonActions decrypt = new CommonActions();
        user.readJSONUser(decrypt.getUserFromKey(key));
        boards = login.loginAs(user.getUser(), user.getPass());
    }

    /**
     * Creation of a dashboar with a specs.
     * @param dataTable input String.
     */
    @When("I create a basic dashboard with a:")
    public void iCreateADashboardWithA(final Map<BoardFields, String> dataTable) {
        BoardCreation newBoard = boards.clickAddBoard();
        dashBoard = newBoard.createNewBoard(dataTable);
    }

    /**
     * Creation of list with a specs.
     * @param value input String.
     */
    @When("I create another lists:")
    public void iCreateAnotherLists(final String value) {
        dashBoard.addList(value);
    }

    /**
     * Creation of a card with a specs.
     * @param data input String.
     */
    @Given("I create a card with a:")
    public void iCreateACardWith(final String data) {
        dashBoard.clickAddCard(data);
    }

    /**
     * Method fo open card.
     * @param value input String.
     */
    @Then("I should see the card {string}")
    public void iShouldSeeTheCard(final String value) {
        dashBoard.verify(value);
        login.closeDriver();
    }
}
