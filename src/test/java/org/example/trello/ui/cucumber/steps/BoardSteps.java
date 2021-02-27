package org.example.trello.ui.cucumber.steps;

import java.util.Map;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import org.example.core.Environment;
import org.example.core.ui.Commons;
import org.example.trello.ui.pages.board.BoardCreation;
import org.example.trello.ui.pages.board.BoardFields;
import org.example.trello.ui.pages.board.Boards;
import org.example.trello.ui.pages.board.SelectedBoard;
import org.example.trello.ui.pages.list.ListAction;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

/**
 * Step definitions for the board Creation.
 */
public class BoardSteps {

    private static final Environment ENVIRONMENT = Environment.getInstance();
    private Boards boardsPage;
    private SelectedBoard board;
    private ListAction listAction;
    private BoardCreation boardCreation;
    private String readJsonUsername = "$['credentials']['%s']['username']";

    /**
     * Constructor BoardSteps.
     *
     * @param boardsPage Boards.
     * @param dashBoard  SelectedDashBoard.
     * @param listAction  ListAction.
     * @param boardCreation  BoardCreation.
     */
    public BoardSteps(final Boards boardsPage, final SelectedBoard dashBoard,
                      final ListAction listAction, final BoardCreation boardCreation) {
        this.boardsPage = boardsPage;
        this.board = dashBoard;
        this.listAction = listAction;
        this.boardCreation = boardCreation;
    }

    /**
     * Creation of a dashboard with a specs.
     *
     * @param dataTable        input String.
     * @param wayToCreateBoard wayToCreateBoard where board will be created from.
     */
    @When("I create a board from {string} with a:")
    public void iCreateABoardWithA(final String wayToCreateBoard, final Map<BoardFields, String> dataTable) {
        boardsPage.clickAddBoard(wayToCreateBoard);
        boardCreation.createNewBoard(dataTable);
        board.setBg(dataTable.get(BoardFields.BACKGROUND));
    }

    /**
     * Dashboard page.
     */
    @Then("^I should see the board$")
    public void iShouldSeeTheBoard() {
        Assert.assertEquals(boardCreation.getTitleString(), board.getName());
        Assert.assertEquals(boardCreation.getPrivacyString(), board.getPrivacy());
        Assert.assertEquals(boardCreation.getBackgroundString(), board.getBG());
    }

    /**
     * Stepdef for invite a member to the board.
     *
     * @param data Input dataTable.
     */
    @Given("I invite a member to the Board:")
    public void iInviteAMemberToTheBoard(final Map<String, String> data) {
        String member = Commons.getUserFromKey(data.get("Member"));
        String accountKey = String.format(readJsonUsername, member);
        board.inviteMember(ENVIRONMENT.getValue(accountKey));
    }

    /**
     * Method for verify if a member exist in the board.
     *
     * @param member Input dataTable.
     */
    @Then("I should see to the member {string} in the board")
    public void iShouldSeeToTheMemberInTheBoard(final String member) {
        String accountKey = String.format(readJsonUsername, Commons.getUserFromKey(member));
        assertEquals(String.format("@%s", ENVIRONMENT.getValue(accountKey)),
                board.membersManageToBoard(ENVIRONMENT.getValue(accountKey)));
    }

    /**
     * Method to delete a member to the board.
     *
     * @param data Input dataTable.
     */
    @When("I remove from boar to member")
    public void iRemoveFromBoarToMember(final Map<String, String> data) {
        String member = Commons.getUserFromKey(data.get("Member"));
        String accountKey = String.format(readJsonUsername, member);
        board.membersManageToBoard(ENVIRONMENT.getValue(accountKey));
        board.deleteMember();
    }

    /**
     * Method for verify a member not exist in the board.
     *
     * @param member account type String.
     */
    @Then("I not should see to the member {string}")
    public void iNotShouldSeeToTheMember(final String member) {
        String accountKey = String.format(readJsonUsername, Commons.getUserFromKey(member));
        assertFalse(board.verifyMemberExist(ENVIRONMENT.getValue(accountKey)));
    }

    /**
     * method for archive list.
     * @param data input data table.
     */
    @Then("I archive the list:")
    public void iArchiveList(final Map<String, String> data) {
        final String nameList = data.get("Name");
        board.openMenuList(nameList);
        listAction.archiveList();
    }

    /**
     * method for verify the lsit as archive.
     * @param table input data table.
     */
    @Then("I shouldn't see the list:")
    public void iShouldSeeTheListsInActivity(final Map<String, String> table) {
        final String nameList = table.get("Name");
        assertFalse(board.verifyListExist(nameList));
    }
}
