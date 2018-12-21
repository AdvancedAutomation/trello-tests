package org.fundacionjala.trello.cucumber.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.fundacionjala.trello.pages.commons.Board;
import org.junit.Assert;

import java.util.Map;

/**
 * Class to run testing add list to an existing board.
 */
public class AddListStep {
    private Board selectedBoard;
    private String listName;

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
     * @param table type Map.
     */
    @And("I add new list into board")
    public void iAddNewListIntoBoard(final Map<String, String> table) {
        listName = table.get("Name");
        selectedBoard.addList(listName);
    }

    /**
     * Method to verify if list created above was just visible.
     */
    @Then("I should see the list")
    public void iShouldSeeTheList() {
        Assert.assertTrue(listName.equals(selectedBoard.getTitleList()));
    }
}
