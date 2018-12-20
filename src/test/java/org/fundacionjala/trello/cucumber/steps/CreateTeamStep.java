package org.fundacionjala.trello.cucumber.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.trello.pages.Boards;
import org.fundacionjala.trello.pages.SelectedTeam;
import org.fundacionjala.trello.pages.TeamCreation;
import org.fundacionjala.trello.pages.TeamFields;
import org.testng.Assert;

import java.util.Map;

/**
 * Step definitions for the Team Creation.
 */
public class CreateTeamStep {

    private Boards boards;
    private SelectedTeam team;
    private TeamCreation newTeam;
    public static final NamesStorage NAMES_STORAGE = NamesStorage.getInstance();

    /**
     * Constructor CreateBoardStep.
     *
     * @param boards Boards.
     * @param team SelectedTeam.
     */
    public CreateTeamStep(final Boards boards, final SelectedTeam team) {
        this.boards = boards;
        this.team = team;
    }

    /**
     * Creation of a Team with a specs.
     * @param dataTable input String.
     */
    @When("I create a team with a:")
    public void iCreateATeamWith(final Map<TeamFields, String> dataTable) {
        newTeam = boards.clickCreateTeam();
        team = newTeam.createTeam(dataTable);
    }

    /**
     * Team page.
     * @param value type String.
     */
    @When("I store as {string}")
    public void iStoreAs(final String value) {
        NAMES_STORAGE.addName(value, newTeam.getUniqueNameTeam());
    }

    /**
     * Team page.
     * @param expected type String.
     */
    @Then("I should see the team new {string}")
    public void iShouldSeeTheTeamNew(final String expected) {
        System.out.println(NAMES_STORAGE.getName(expected));
        System.out.println(team.getValue(".u-inline"));
        Assert.assertTrue(NAMES_STORAGE.getName(expected).equals(team.getValue(".u-inline")));
    }
}
