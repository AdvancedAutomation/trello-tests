package org.fundacionjala.trello.cucumber.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.fundacionjala.pages.Board;

/**
 * Class to run testing add list to an existing board.
 */
public class AddListStep {
    private Board selectedBoard;

    /**
     * Class constructor.
     *
     * @param board type Board.
     */
    public AddListStep(final Board board) {
        this.selectedBoard = board;
    }

    /**
     * Method to create a new list into board create above.
     *
     * @param value type String.
     */
    @And("I add new list into board")
    public void iAddNewListIntoBoard(final String value) {
        selectedBoard.addList(value);
    }

    /**
     * Method to verify if list created above was just visible.
     */
    @Then("I should see the list")
    public void iShouldSeeTheList() {
        selectedBoard.canAddCard();
    }
}
