package org.fundacionjala.trello.cucumber.steps.ui;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.trello.cucumber.steps.NamesStorage;
import org.fundacionjala.trello.pages.board.Boards;
import org.fundacionjala.trello.pages.common.SideBarMain;
import org.fundacionjala.trello.pages.team.SelectedTeam;
import org.fundacionjala.trello.pages.team.TabMembers;
import org.fundacionjala.trello.pages.team.TabSettings;
import org.fundacionjala.trello.pages.team.TeamCreation;
import org.fundacionjala.trello.pages.team.TeamFields;

import java.util.Map;

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
    private TabMembers tabMembers;

    /**
     * Constructor BoardSteps.
     *
     * @param boards      Boards.
     * @param team        SelectedTeam.
     * @param sideBarMain Side Bar Main.
     * @param tabSettings Tab Settings.
     * @param tabMembers  Tab Members.
     */
    public TeamSteps(final Boards boards, final SelectedTeam team,
                     final SideBarMain sideBarMain, final TabSettings tabSettings, final TabMembers tabMembers) {
        this.boards = boards;
        this.team = team;
        this.sideBarMain = sideBarMain;
        this.tabSettings = tabSettings;
        this.tabMembers = tabMembers;
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

    /**
     * Given step for select a team.
     *
     * @param key Input key for recognize the team.
     */
    @Given("I select the Team {string}")
    public void iSelectTheTeam(final String key) {
        sideBarMain.selectTeam(NAMES_STORAGE.getName(key));
    }

    /**
     * When step for go to the team setting.
     */
    @When("I go to team setting")
    public void iGoToTeamSetting() {
        sideBarMain.goTeamSettings();
    }

    /**
     * Step for delete a team.
     */
    @And("I delete the team")
    public void iDeleteTheTeam() {
        tabSettings.deleteTeam();
    }

    /**
     * Then Step for verify if the team was deleted.
     */
    @Then("I shouldn't see the team in the left bar")
    public void iShouldnTSeeTheTeamInTheLeftBar() {
        // WIP
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

    /**
     * Step for verify if the member was deleted.
     *
     * @param dataTable Input datable.
     */
    @Then("I didnt see the member in the list")
    public void iDidntSeeTheMemberInTheList(final Map<String, String> dataTable) {
        // WIP
    }
}
