package org.fundacionjala.trello.cucumber.steps.ui;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.fundacionjala.trello.pages.SelectedBoard;
import org.fundacionjala.trello.pages.SelectedCard;

import static org.testng.Assert.assertEquals;

/**
 * Step definitions for the Dashboard Creation.
 */
public class CardSteps {

    private SelectedBoard board;
    private SelectedCard card;

    /**
     * Constructor CardSteps.
     * @param board SelectedDashBoard.
     */
    public CardSteps(final SelectedBoard board) {
        this.board = board;
    }

    /**
     * Creation of a card with a specs.
     * @param data input String.
     */
    @Given("I create a card with a:")
    public void iCreateACardWith(final String data) {
        board.clickAddCard(data);
    }

    /**
     * Creation of list with a specs.
     * @param value input String.
     */
    @When("I create another lists:")
    public void iCreateAnotherLists(final String value) {
        board.addList(value);
    }

    /**
     * Method verify card new.
     * @param expected input String.
     */
    @Then("I should see the card {string}")
    public void iShouldSeeTheCard(final String expected) {
        assertEquals(card.getValue(), expected);
    }

    /**
     * Method for open card new created.
     */
    @When("I open the card new created")
    public void iSelectCardNewCreated() {
        card = board.clickOpenCard();
    }
}
