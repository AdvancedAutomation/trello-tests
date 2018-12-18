package org.fundacionjala.trello.cucumber.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.trello.pages.Boards;
import org.fundacionjala.trello.pages.SelectedDashBoard;
import org.fundacionjala.trello.pages.BoardCreation;
import org.fundacionjala.trello.pages.BoardFields;

import java.util.Map;

/**
 * Step definitions for the board Creation.
 */
public class CreateBoardStep {

    private Boards boards;
    private SelectedDashBoard dashBoard;

    /**
     * Constructor CreateBoardStep.
     *
     * @param boards Boards.
     * @param dashBoard SelectedDashBoard.
     */
    public CreateBoardStep(final Boards boards, final SelectedDashBoard dashBoard) {
        this.boards = boards;
        this.dashBoard = dashBoard;
    }

    /**
     * Creation of a dashboard with a specs.
     * @param dataTable input String.
     */
    @When("I create a board with a:")
    public void iCreateABoardWithA(final Map<BoardFields, String> dataTable) {
        BoardCreation newBoard = boards.clickAddBoard();
        dashBoard = newBoard.createNewBoard(dataTable);
    }

    /**
     * Dashboard page.
     */
    @Then("^I should see the board$")
    public void iShouldSeeTheBoard() {
        dashBoard.addList("hi");
    }
}
