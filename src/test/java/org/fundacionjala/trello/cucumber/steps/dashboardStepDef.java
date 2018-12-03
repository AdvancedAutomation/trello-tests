package org.fundacionjala.trello.cucumber.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.fundacionjala.core.Environment;
import org.fundacionjala.trello.pages.*;

import java.util.List;

public class dashboardStepDef {

    Home home;
    Login login;
    private Boards boards;
    SelectedDashBoard dashBoard;

    @Given("I am on the Home page Trello")
    public void onTrello() {
        home = new Home();
    }

    @When("I Log in with user {int}")
    public void logIn(int numUser) {
        login = home.clickInitLink();
        Environment user = new Environment(numUser);
        boards = login.loginAs(user.getUsr(), user.getPwd());
    }

    @When("I create a dashboard with a:")
    public void iCreateADashboardWithA(DataTable dataTable) {
        List<String> data = dataTable.asList(String.class);
        BoardCreation newBoard = boards.clickAddBoard();
        dashBoard = newBoard.createNewBoard(data);
    }

    @Then("I should see the dashboard")
    public void seeDashboard() {
        home.closeDriver();
    }
}
