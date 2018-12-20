package org.fundacionjala.trello.cucumber.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.fundacionjala.trello.pages.commons.Board;
import org.junit.Assert;

import java.util.Iterator;
import java.util.List;

/**
 * Class to test add several lists to an existing board.
 */
public class AddSeveralListsStep {
    private Board selectedBoard;

    /**
     * Explicit constructor method.
     *
     * @param board type Board.
     */
    public AddSeveralListsStep(final Board board) {
        this.selectedBoard = board;
    }

    /**
     * Method to add lists from data table.
     *
     * @param lists type data table.
     */
    @And("I add several lists into board")
    public void iAddSeveralListsIntoBoard(final List<String> lists) {
        for (Iterator<String> it = lists.iterator(); it.hasNext();) {
            selectedBoard.addList(it.next());
        }
    }

    /**
     * Method to assert expected number of list created.
     *
     * @param expectedListCreated type integer.
     */
    @Then("I should see these {int} lists")
    public void iShouldSeeTheseLists(final int expectedListCreated) {
        Assert.assertEquals(expectedListCreated, selectedBoard.getSizeList());
    }
}
