package org.fundacionjala.trello.cucumber.steps.ui;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.core.Environment;
import org.fundacionjala.core.ui.Commons;
import org.fundacionjala.trello.pages.board.BoardCreation;
import org.fundacionjala.trello.pages.board.BoardFields;
import org.fundacionjala.trello.pages.board.Boards;
import org.fundacionjala.trello.pages.board.SelectedBoard;
import org.junit.Assert;

import java.util.Map;

/**
 * Step definitions for the board Creation.
 */
public class BoardSteps {

    private static final Environment ENVIRONMENT = Environment.getInstance();
    private Boards boardsPage;
    private SelectedBoard board;
    private BoardCreation newBoardCreation;

    /**
     * Constructor BoardSteps.
     *
     * @param boardsPage Boards.
     * @param dashBoard  SelectedDashBoard.
     */
    public BoardSteps(final Boards boardsPage, final SelectedBoard dashBoard) {
        this.boardsPage = boardsPage;
        this.board = dashBoard;
    }

    /**
     * Creation of a dashboard with a specs.
     *
     * @param dataTable input String.
     * @param place     place where board will be created from.
     */
    @When("I create a board from {string} with a:")
    public void iCreateABoardWithA(final String place, final Map<BoardFields, String> dataTable) {
        newBoardCreation = boardsPage.clickAddBoard(place);
        board = newBoardCreation.createNewBoard(dataTable);
        board.setPrivacy(dataTable.get(BoardFields.PRIVACY));
        board.setBg(dataTable.get(BoardFields.BACKGROUND));
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

    @Given("I invite a member to the Board:")
    public void iInviteAMemberToTheBoard(Map<String, String> data) {
        String member = Commons.getUserFromKey(data.get("Member"));
        String accountKey = String.format("$['credentials']['%s']['username']", member);
        board.inviteMember(ENVIRONMENT.getValue(accountKey));
    }
}
