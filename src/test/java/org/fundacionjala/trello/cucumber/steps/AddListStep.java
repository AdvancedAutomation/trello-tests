package org.fundacionjala.trello.cucumber.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Class to run testing add list to an existing board.
 */
public class AddListStep {

    /**
     * Method to load Trello app.
     */
    @Given("Trello's home page")
    public void trelloSHomePage() {
    }

    /**
     * Method to login into Trello app.
     */
    @When("I logged as a owner")
    public void iLoggedAsAOwner() {
    }

    /**
     * Method to create a new board.
     */
    @And("I was create a new board")
    public void iWasCreateANewBoard() {
    }

    /**
     * Method to create a new list into board create above.
     */
    @And("I add new list into board")
    public void iAddNewListIntoBoard() {

    }

    /**
     * Method to verify if list created above was just visible.
     */
    @Then("I should see the list")
    public void iShouldSeeTheList() {
    }
}
