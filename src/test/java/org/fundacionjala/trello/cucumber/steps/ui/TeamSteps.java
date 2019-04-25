package org.fundacionjala.trello.cucumber.steps.ui;

import java.util.Map;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import org.fundacionjala.core.NamesStorage;
import org.fundacionjala.trello.pages.board.Boards;
import org.fundacionjala.trello.pages.common.SideBarMain;
import org.fundacionjala.trello.pages.team.SelectedTeam;
import org.fundacionjala.trello.pages.team.TabSettings;
import org.fundacionjala.trello.pages.team.TeamCreation;
import org.fundacionjala.trello.pages.team.TeamFields;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Step definitions for the Team Creation.
 */
public class TeamSteps {

    private static final NamesStorage NAMES_STORAGE = NamesStorage.getInstance();

    @Autowired
    private Boards boards;

    @Autowired
    private SelectedTeam team;

    @Autowired
    private TeamCreation newTeam;

    @Autowired
    private SideBarMain sideBarMain;

    @Autowired
    private TabSettings tabSettings;

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
