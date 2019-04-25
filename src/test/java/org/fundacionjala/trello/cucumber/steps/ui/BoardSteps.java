package org.fundacionjala.trello.cucumber.steps.ui;

import java.util.Map;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import org.fundacionjala.core.Environment;
import org.fundacionjala.core.ui.Commons;
import org.fundacionjala.trello.pages.board.BoardCreation;
import org.fundacionjala.trello.pages.board.BoardFields;
import org.fundacionjala.trello.pages.board.Boards;
import org.fundacionjala.trello.pages.board.SelectedBoard;
import org.fundacionjala.trello.pages.list.ListAction;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

/**
 * Step definitions for the board Creation.
 */
public class BoardSteps {

    private static final Environment ENVIRONMENT = Environment.getInstance();

    @Autowired
    private Boards boardsPage;

    @Autowired
    private SelectedBoard board;

    private BoardCreation newBoardCreation;
    private String readJsonUsername = "$['credentials']['%s']['username']";

    /**
     * Creation of a dashboard with a specs.
     *
     * @param dataTable        input String.
     * @param wayToCreateBoard wayToCreateBoard where board will be created from.
     */
    @When("I create a board from {string} with a:")
    public void iCreateABoardWithA(final String wayToCreateBoard, final Map<BoardFields, String> dataTable) {
        newBoardCreation = boardsPage.clickAddBoard(wayToCreateBoard);
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
        ListAction listAction = new ListAction();
        listAction.archiveList();
    }

    /**
     * method for verify the lsit as archive.
     * @param table input data table.
     */
    @Then("I don't should see the list:")
    public void iShouldSeeTheListsInActivity(final Map<String, String> table) {
        final String nameList = table.get("Name");
        assertFalse(board.verifyListExist(nameList));
    }
}
