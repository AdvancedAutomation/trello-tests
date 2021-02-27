package org.example.trello.ui.cucumber.steps;

import java.util.Map;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import org.example.trello.ui.pages.board.BoardCreation;
import org.example.trello.ui.pages.board.BoardFields;
import org.example.trello.ui.pages.board.SelectedBoard;
import org.example.trello.ui.pages.team.TabBoards;
import org.example.trello.ui.pages.team.TabMembers;
import org.example.trello.ui.pages.team.TabSettings;

/**
 * Step definitions for the Team taps Step.
 */
public class TeamTabsSteps {
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
    public TeamTabsSteps(final TabSettings tabSettings,
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




