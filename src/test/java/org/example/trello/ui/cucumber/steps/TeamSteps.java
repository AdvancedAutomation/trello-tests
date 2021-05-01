package org.example.trello.ui.cucumber.steps;

import java.util.Map;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.example.core.ScenarioContext;
import org.example.trello.ui.pages.board.Boards;
import org.example.trello.ui.pages.common.SideBarMain;
import org.example.trello.ui.pages.team.SelectedTeam;
import org.example.trello.ui.pages.team.TabSettings;
import org.example.trello.ui.pages.team.TeamCreation;
import org.example.trello.ui.pages.team.TeamFields;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Step definitions for the Team Creation.
 */
public class TeamSteps {

    private final ScenarioContext context;
    private final SideBarMain sideBarMain;
    private final TabSettings tabSettings;
    private final Boards boards;
    private SelectedTeam team;
    private TeamCreation newTeam;

    public TeamSteps(final ScenarioContext context, final Boards boards, final SelectedTeam team,
                     final SideBarMain sideBarMain, final TabSettings tabSettings) {
        this.context = context;
        this.boards = boards;
        this.team = team;
        this.sideBarMain = sideBarMain;
        this.tabSettings = tabSettings;
    }

    /**
     * Creation of a Team with a specs.
     *
     * @param dataTable input String.
     */
    @When("I create a team with a:")
    public void iCreateATeamWith(final Map<TeamFields, String> dataTable) {
        newTeam = boards.clickCreateTeam();
        team = newTeam.createTeam(dataTable);
        context.setContext("Team", newTeam.getUniqueNameTeam());
    }

    /**
     * Team page.
     *
     * @param value type String.
     */
    @When("I store as {string}")
    public void iStoreAs(final String value) {
        context.setContext(value, newTeam.getUniqueNameTeam());
    }

    /**
     * Team page.
     *
     * @param expected type String.
     */
    @Then("I should see the team new {string}")
    public void iShouldSeeTheTeamNew(final String expected) {
        assertEquals(team.getValue(), context.getContext(expected));
    }

    /**
     * Given step for select a team.
     *
     * @param key Input key for recognize the team.
     */
    @Given("I select the Team {string}")
    public void iSelectTheTeam(final String key) {
        sideBarMain.selectTeam(context.getContext(key));
    }

    /**
     * When step for go to the team setting.
     */
    @When("I go to team setting")
    public void iGoToTeamSetting() {
        sideBarMain.goTeamSettings();
    }

    /**
     * Then Step for verify if the team was deleted.
     */
    @Then("I shouldn't see the team in the left bar")
    public void iShouldnTSeeTheTeamInTheLeftBar() {
        // WIP
    }

    /**
     * Step for verify if the member was deleted.
     *
     * @param dataTable Input datable.
     */
    @Then("I didnt see the member in the list")
    public void iDidntSeeTheMemberInTheList(final Map<String, String> dataTable) {
        // WIP
    }


    /**
     * When step for go to the team setting.
     */
    @When("I go to tab setting")
    public void iGoToTabSetting() {
        team.openTabSettings();
    }

    /**
     * When step for change the privacy of the team.
     *
     * @param dataTable input data table value.
     */
    @When("I change the privacy of the team:")
    public void iChangePrivacyTeam(final Map<String, String> dataTable) {
        final String listName = dataTable.get("privacy");
        tabSettings.changePrivacyTeam(listName);
    }

    /**
     * Then see the privacy change in team.
     *
     * @param dataTable input value.
     */
    @Then("I see the privacy change in team:")
    public void iSeePrivacyTeam(final Map<String, String> dataTable) {
        final String listName = dataTable.get("privacy");
        assertTrue(tabSettings.verifyChangePrivacyToTeam(listName));
    }

}
