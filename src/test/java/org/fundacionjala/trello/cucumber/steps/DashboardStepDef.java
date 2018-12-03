package org.fundacionjala.trello.cucumber.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.core.Environment;
import org.fundacionjala.trello.pages.BoardCreation;
import org.fundacionjala.trello.pages.Boards;
import org.fundacionjala.trello.pages.Home;
import org.fundacionjala.trello.pages.Login;
import org.fundacionjala.trello.pages.SelectedDashBoard;

import java.util.Map;

/**
 * Step definitions for the Dashboard Creation.
 */
public class DashboardStepDef {

    private Home home;
    private Login login;
    private Boards boards;
    private SelectedDashBoard dashBoard;

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
     * @param numUser int for select a user.
     */
    @When("I Log in with user {int}")
    public void logIn(int numUser) {
        login = home.clickInitLink();
        Environment user = new Environment(numUser);
        boards = login.loginAs(user.getUsr(), user.getPwd());
    }

    /**
     * Cretion of a dashboar with a specs.
     *
     * @param dataTable input String.
     */
    @When("I create a dashboard with a:")
    public void iCreateADashboardWithA(final Map<String, String> dataTable) {

        BoardCreation newBoard = boards.clickAddBoard();
    dashBoard = newBoard.createNewBoard(dataTable);
    }

    /**
     * Dashboard page.
     */
    @Then("I should see the dashboard")
    public void seeDashboard() {
        home.closeDriver();
    }
}
