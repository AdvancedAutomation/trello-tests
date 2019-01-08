package org.fundacionjala.trello.cucumber.steps.ui;

import java.util.List;
import java.util.Map;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import org.fundacionjala.trello.pages.common.Board;

import static org.testng.Assert.assertEquals;

/**
 * Class to run testing add list to an existing board.
 */
public class ListSteps {
    private Board selectedBoard;
    private String listName;

    /**
     * Class constructor.
     *
     * @param board type Board.
     */
    public ListSteps(final Board board) {
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
        assertEquals(selectedBoard.getTitleList(), listName);
    }

    /**
     * Method to add lists from data table.
     *
     * @param lists type data table.
     */
    @And("I add several lists into board")
    public void iAddSeveralListsIntoBoard(final List<String> lists) {
        selectedBoard.addSeveralList(lists);
    }

    /**
     * Method to assert expected number of list created.
     *
     * @param expectedListCreated type integer.
     */
    @Then("I should see these {int} lists")
    public void iShouldSeeTheseLists(final int expectedListCreated) {
        assertEquals(selectedBoard.getSizeList(), expectedListCreated);
    }
}
