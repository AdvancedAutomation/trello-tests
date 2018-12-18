package org.fundacionjala.trello.cucumber.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.trello.pages.SelectedDashBoard;

/**
 * Step definitions for the Dashboard Creation.
 */
public class CreateCardStep {

    private SelectedDashBoard dashBoard;

    /**
     * Constructor CreateCardStep.
     * @param dashBoard SelectedDashBoard.
     */
    public CreateCardStep(final SelectedDashBoard dashBoard) {
        this.dashBoard = dashBoard;
    }

    /**
     * Creation of a card with a specs.
     * @param data input String.
     */
    @Given("I create a card with a:")
    public void iCreateACardWith(final String data) {
        dashBoard.clickAddCard(data);
    }

    /**
     * Creation of list with a specs.
     * @param value input String.
     */
    @When("I create another lists:")
    public void iCreateAnotherLists(final String value) {
        dashBoard.addList(value);
    }

    /**
     * Method fo open card.
     * @param value input String.
     */
    @Then("I should see the card {string}")
    public void iShouldSeeTheCard(final String value) {
        dashBoard.verify(value);
    }
}
