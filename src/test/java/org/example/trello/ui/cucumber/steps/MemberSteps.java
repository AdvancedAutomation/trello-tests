package org.example.trello.ui.cucumber.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.example.core.Environment;
import org.example.core.ui.Commons;
import org.example.trello.ui.pages.team.SelectedTeam;
import org.example.trello.ui.pages.team.TabMembers;

import static org.testng.Assert.assertEquals;

/**
 * Class to run testing add list to an existing board.
 */
public class MemberSteps {

    private static final Environment ENVIRONMENT = Environment.getInstance();
    private SelectedTeam selectedTeam;
    private TabMembers tabMembers;

    /**
     * Class constructor.
     *
     * @param team type SelectedTeam.
     * @param tabMembers TabMembers.
     */
    public MemberSteps(final SelectedTeam team, final TabMembers tabMembers) {
        this.selectedTeam = team;
        this.tabMembers = tabMembers;
    }

    /**
     * Method to create a new list into board create above.
     */
    @Given("I select tab members")
    public void iSelectTabMembers() {
        selectedTeam.openTabMembers();
    }

    /**
     * Method to create a new list into board create above.
     *
     * @param member type String.
     */
    @When("I invite a member to the Team:")
    public void iInviteToMemberToTeam(final String member) {
        String accountKey = String.format("$['credentials']['%s']['username']", Commons.getUserFromKey(member));
        tabMembers.clickInviteButton(ENVIRONMENT.getValue(accountKey));
    }

    /**
     * Method to create a new list into board create above.
     *
     * @param member type String.
     */
    @Then("I should see to the member {string} in the tab members")
    public void iShouldSeeToTheMemberInTheTabMembers(final String member) {
        String accountKey = String.format("$['credentials']['%s']['username']", Commons.getUserFromKey(member));
        assertEquals(tabMembers.getMemberAccount(ENVIRONMENT.getValue(accountKey)),
                String.format("@%s", ENVIRONMENT.getValue(accountKey)));
    }
}
