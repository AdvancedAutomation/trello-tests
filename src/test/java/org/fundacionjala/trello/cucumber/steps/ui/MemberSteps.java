package org.fundacionjala.trello.cucumber.steps.ui;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.testng.Assert.assertEquals;

import org.fundacionjala.core.Environment;
import org.fundacionjala.core.ui.Commons;
import org.fundacionjala.trello.pages.SelectedTeam;
import org.fundacionjala.trello.pages.TabMembers;


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
     */
    public MemberSteps(final SelectedTeam team) {
        this.selectedTeam = team;
    }

    /**
     * Method to create a new list into board create above.
     */
    @Given("I select tab members")
    public void iSelectTabMembers() {
        tabMembers = selectedTeam.openTabMembers();
    }

    /**
     * Method to create a new list into board create above.
     * @param member type String.
     */
    @When("I invite to member:")
    public void iInviteToMember(final String member) {
        String accountKey = String.format("$['credentials']['%s']['username']", Commons.getUserFromKey(member));
        tabMembers.clickInviteButton(ENVIRONMENT.getValue(accountKey));
    }

    /**
     * Method to create a new list into board create above.
     * @param member type String.
     */
    @Then("I should see to the member {string} in the tab members")
    public void iShouldSeeToTheMemberInTheTabMembers(final String member) {
        String accountKey = String.format("$['credentials']['%s']['username']", Commons.getUserFromKey(member));
        assertEquals(tabMembers.getXPath(ENVIRONMENT.getValue(accountKey)),
                String.format("@%s", ENVIRONMENT.getValue(accountKey)));
    }
}
