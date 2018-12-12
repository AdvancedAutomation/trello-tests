package org.fundacionjala.trello.cucumber.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.core.Environment;
import org.fundacionjala.trello.pages.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Map;

/**
 * Step definitions for the Dashboard Creation.
 */
public class Demo2 {

    private Home home;
    private Boards boards;
    private SelectedDashBoard dashBoard;

    /**
     * Given of in page of trello.
     */
    @Given("I Log in with user {string}")
    public void iLogInWithUser(String arg0) {
        home = new Home();
        Login login = home.clickInitLink();
        Environment user = new Environment();
        user.readJSONUser(arg0);
        boards = login.loginAs(user.getUser(), user.getPass());
    }

    /**
     * Creation of a dashboar with a specs.
     *
     * @param dataTable input String.
     */
    @When("I create a basic dashboard with a:")
    public void iCreateADashboardWithA(final Map<BoardFields, String> dataTable) {
        BoardCreation newBoard = boards.clickAddBoard();
        dashBoard = newBoard.createNewBoard(dataTable);
    }

    @When("I create another lists:")
    public void iCreateAnotherLists(final String value) {
        dashBoard.addList(value);
    }

    @Given("I create a card with a:")
    public void iCreateACardWith(final String data) {
        dashBoard.clickAddCard(data);
    }

    @Then("I should see the card {string}")
    public void iShouldSeeTheCard(String value) {
        dashBoard.verify(value);
        home.closeDriver();

    }

//    @When("I create a team {string}:")
//    public void iCreateATeam(final String nameTeam) {
//        TeamCreation newTeam = boards.clickCreateTeam(nameTeam);
//        newTeam.addMembers();
//    }
}
