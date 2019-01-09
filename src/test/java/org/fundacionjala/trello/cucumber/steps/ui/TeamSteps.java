package org.fundacionjala.trello.cucumber.steps.ui;

import java.util.Map;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.fundacionjala.trello.cucumber.steps.NamesStorage;
import org.fundacionjala.trello.pages.board.Boards;
import org.fundacionjala.trello.pages.common.SideBarMain;
import org.fundacionjala.trello.pages.team.SelectedTeam;
import org.fundacionjala.trello.pages.team.TabSettings;
import org.fundacionjala.trello.pages.team.TeamCreation;
import org.fundacionjala.trello.pages.team.TeamFields;

import static org.testng.Assert.assertEquals;

/**
 * Step definitions for the Team Creation.
 */
public class TeamSteps {

    private static final NamesStorage NAMES_STORAGE = NamesStorage.getInstance();
    private Boards boards;
    private SelectedTeam team;
    private TeamCreation newTeam;
    private SideBarMain sideBarMain;
    private TabSettings tabSettings;

    /**
     * Constructor BoardSteps.
     *
     * @param boards Boards.
     * @param team   SelectedTeam.
     */
    public TeamSteps(final Boards boards, final SelectedTeam team,
                     final SideBarMain sideBarMain, final TabSettings tabSettings) {
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
        NAMES_STORAGE.addName("Team", newTeam.getUniqueNameTeam());
    }

    /**
     * Team page.
     *
     * @param value type String.
     */
    @When("I store as {string}")
    public void iStoreAs(final String value) {
        NAMES_STORAGE.addName(value, newTeam.getUniqueNameTeam());
    }

    /**
     * Team page.
     *
     * @param expected type String.
     */
    @Then("I should see the team new {string}")
    public void iShouldSeeTheTeamNew(final String expected) {
        assertEquals(team.getValue(), NAMES_STORAGE.getName(expected));
    }

    @Given("I select the Team {string}")
    public void iSelectTheTeam(String key) {
        sideBarMain.selectTeam(NAMES_STORAGE.getName(key));
    }

    @When("I go to team setting")
    public void iGoToTeamSetting() {
        sideBarMain.goTeamSettings();
    }

    @And("I delete the team")
    public void iDeleteTheTeam() {
        tabSettings.deleteTeam();
    }

    @Then("I shouldn't see the team in the left bar")
    public void iShouldnTSeeTheTeamInTheLeftBar() {

    }
}
