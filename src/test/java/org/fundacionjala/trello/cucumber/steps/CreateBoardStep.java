package org.fundacionjala.trello.cucumber.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.trello.pages.Boards;
import org.fundacionjala.trello.pages.SelectedBoard;
import org.fundacionjala.trello.pages.BoardCreation;
import org.fundacionjala.trello.pages.BoardFields;
import org.junit.Assert;

import java.util.Map;

/**
 * Step definitions for the board Creation.
 */
public class CreateBoardStep {

    private Boards boardsPage;
    private SelectedBoard board;
    private BoardCreation newBoardCreation;

    /**
     * Constructor CreateBoardStep.
     *
     * @param boardsPage Boards.
     * @param dashBoard SelectedDashBoard.
     */
    public CreateBoardStep(final Boards boardsPage, final SelectedBoard dashBoard) {
        this.boardsPage = boardsPage;
        this.board = dashBoard;
    }

    /**
     * Creation of a dashboard with a specs.
     * @param dataTable input String.
     * @param place place where board will be created from.
     */
    @When("I create a board from {string} with a:")
    public void iCreateABoardWithA(final String place, final Map<BoardFields, String> dataTable) {
        newBoardCreation = boardsPage.clickAddBoard(place);
        board = newBoardCreation.createNewBoard(dataTable);
    }

    /**
     * Dashboard page.
     */
    @Then("^I should see the board$")
    public void iShouldSeeTheBoard() {
        Assert.assertEquals(newBoardCreation.getTitleString(), board.getName());
        Assert.assertEquals(newBoardCreation.getPrivacyString(), board.getPrivacy());
        Assert.assertEquals(newBoardCreation.getBackgroundString(), board.getBG());
    }
}
