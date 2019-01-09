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

import static org.testng.Assert.*;

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

    /**
     * Stepdef for invite a member to the board.
     *
     * @param data Input dataTable.
     */
    @Given("I invite a member to the Board:")
    public void iInviteAMemberToTheBoard(final Map<String, String> data) {
        String member = Commons.getUserFromKey(data.get("Member"));
        String accountKey = String.format("$['credentials']['%s']['username']", member);
        board.inviteMember(ENVIRONMENT.getValue(accountKey));
    }

    /**
     * Stepdef for invite a member to the board.
     *
     * @param member Input dataTable.
     */
    @Then("I should see to the member {string} in the board")
    public void iShouldSeeToTheMemberInTheBoard(final String member) {
        String accountKey = String.format("$['credentials']['%s']['username']", Commons.getUserFromKey(member));
        assertEquals(String.format("@%s",ENVIRONMENT.getValue(accountKey)),
                board.clickBoardMembers(ENVIRONMENT.getValue(accountKey)));
    }

    /**
     * Stepdef for invite a member to the board.
     *
     * @param data Input dataTable.
     */
    @When("I remove from boar to member")
    public void iRemoveFromBoarToMember(final Map<String, String> data) {
        String member = Commons.getUserFromKey(data.get("Member"));
        String accountKey = String.format("$['credentials']['%s']['username']", member);
        board.clickBoardMembers(ENVIRONMENT.getValue(accountKey));
        board.deleteMember();
    }

    /**
     * Stepdef for invite a member to the board.
     *
     * @param member Input dataTable.
     */
    @Then("I not should see to the member {string}")
    public void iNotShouldSeeToTheMember(final String member) {
        String accountKey = String.format("$['credentials']['%s']['username']", Commons.getUserFromKey(member));
        assertFalse(board.verifyMemberExist(ENVIRONMENT.getValue(accountKey)));
    }
}
