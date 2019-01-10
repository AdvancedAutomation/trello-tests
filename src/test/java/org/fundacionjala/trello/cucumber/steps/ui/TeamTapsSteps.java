package org.fundacionjala.trello.cucumber.steps.ui;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.fundacionjala.trello.pages.board.BoardCreation;
import org.fundacionjala.trello.pages.board.BoardFields;
import org.fundacionjala.trello.pages.board.SelectedBoard;
import org.fundacionjala.trello.pages.team.TabBoards;
import org.fundacionjala.trello.pages.team.TabMembers;
import org.fundacionjala.trello.pages.team.TabSettings;

import java.util.Map;

/**
 * Step definitions for the Team taps Step.
 */
public class TeamTapsSteps {
    private TabSettings tabSettings;
    private TabBoards tabBoards;
    private TabMembers tabMembers;

    /**
     * Constructor BoardSteps.
     *
     * @param tabSettings Tab Settings.
     * @param tabMembers  Tab Members.
     * @param tabBoards   Tab Boards.
     */
    public TeamTapsSteps(final TabSettings tabSettings,
                         final TabMembers tabMembers, final TabBoards tabBoards) {
        this.tabSettings = tabSettings;
        this.tabBoards = tabBoards;
        this.tabMembers = tabMembers;
    }

    /**
     * Step for delete a team.
     */
    @And("I delete the team")
    public void iDeleteTheTeam() {
        tabSettings.deleteTeam();
    }

    /**
     * Creation of a dashboard with a specs.
     *
     * @param dataTable input String.
     */
    @When("I create a team board:")
    public void iCreateATeamBoard(final Map<BoardFields, String> dataTable) {
        BoardCreation newBoardCreation = tabBoards.clickAddBoard();
        SelectedBoard board = newBoardCreation.createNewBoard(dataTable);
        board.setPrivacy(dataTable.get(BoardFields.PRIVACY));
        board.setBg(dataTable.get(BoardFields.BACKGROUND));
    }


    /**
     * When Step for delete a member.
     *
     * @param dataTable Input dataTable.
     */
    @When("I delete the team member:")
    public void iDeleteTheTeamMember(final Map<String, String> dataTable) {
        tabMembers.deleteTeamMember(dataTable.get("Name"));
    }


}




