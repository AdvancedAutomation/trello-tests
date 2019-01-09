package org.fundacionjala.trello.cucumber.steps.ui;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.core.Environment;
import org.fundacionjala.core.ui.Commons;
import org.fundacionjala.trello.pages.board.SelectedBoard;
import org.fundacionjala.trello.pages.card.SelectedCard;

import java.util.Map;

import static org.testng.Assert.assertEquals;


/**
 * Step definitions for the Dashboard Creation.
 */
public class CardSteps {

    private static final Environment ENVIRONMENT = Environment.getInstance();
    private SelectedBoard board;
    private SelectedCard card;

    /**
     * Constructor CardSteps.
     *
     * @param board SelectedDashBoard.
     */
    public CardSteps(final SelectedBoard board) {
        this.board = board;
    }

    /**
     * Creation of a card with a specs.
     *
     * @param data input String.
     */
    @Given("I create a card with a:")
    public void iCreateACardWith(final String data) {
        board.clickAddCard(data);
    }

    /**
     * Creation of list with a specs.
     *
     * @param value input String.
     */
    @When("I create another lists:")
    public void iCreateAnotherLists(final String value) {
        board.addList(value);
    }

    /**
     * Method verify card new.
     *
     * @param expected input String.
     */
    @Then("I should see the card {string}")
    public void iShouldSeeTheCard(final String expected) {
        assertEquals(card.getValue(), expected);
    }

    /**
     * Method for open card new created.
     */
    @When("I select the card:")
    public void iSelectTheCard(final Map<String, String> dataTable) {
        card = board.selectCard(dataTable.get("List Name"), dataTable.get("Card Name"));
    }

    @When("I archive the card")
    public void iArchiveTheCard() {
        card.archiveCard();
    }

    @And("I delete the card")
    public void iDeleteTheCard() {
        card.deleteCard();
    }

    @Then("I expect the card doesn't appear")
    public void iExpectTheCardDoesnTAppear() {

    }

    @When("I assign a member to the card:")
    public void iAssignAMemberToTheCard(Map<String, String> data) {
        String member = Commons.getUserFromKey(data.get("Member"));
        String accountKey = String.format("$['credentials']['%s']['username']", member);
        card.assignMemberToCard(ENVIRONMENT.getValue(accountKey));
    }

    @Then("I see the member in the card")
    public void iSeeTheMemberInTheCard() {
    }
}
