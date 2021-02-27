package org.example.trello.ui.cucumber.steps;

import java.util.List;
import java.util.Map;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.example.trello.ui.pages.common.Board;
import org.example.trello.ui.pages.common.SideBarMain;

import static org.testng.Assert.assertEquals;

/**
 * Class to run testing add list to an existing board.
 */
public class ListSteps {
    private Board board;
    private SideBarMain sideBarMain;
    private String listName;

    /**
     * Class constructor.
     *
     * @param board type Board.
     * @param sideBarMain SideBarMain.
     */
    public ListSteps(final Board board, final SideBarMain sideBarMain) {
        this.board = board;
        this.sideBarMain = sideBarMain;
    }

    /**
     * Method to create a new list into board create above.
     *
     * @param table type Map.
     */
    @And("I add new list into board")
    public void iAddNewListIntoBoard(final Map<String, String> table) {
        listName = table.get("Name");
        board.addList(listName);
    }

    /**
     * Method to verify if list created above was just visible.
     */
    @Then("I should see the list")
    public void iShouldSeeTheList() {
        assertEquals(board.getTitleList(listName), listName);
    }

    /**
     * Method to add lists from data table.
     *
     * @param lists type data table.
     */
    @And("I add several lists into board")
    public void iAddSeveralListsIntoBoard(final List<String> lists) {
        board.addSeveralList(lists);
    }

    /**
     * Method to assert expected number of list created.
     *
     * @param expectedListCreated type integer.
     */
    @Then("I should see these {int} lists")
    public void iShouldSeeTheseLists(final int expectedListCreated) {
        assertEquals(board.getSizeList(), expectedListCreated);
    }

    /**
     * Method to edit the name of list.
     *
     * @param table new name
     */
    @When("I select and edit the list")
    public void iSelectTheList(final Map<String, String> table) {
        board.editList(table.get("Name"));
    }

    /**
     * Method for change the list to the board.
     *
     * @param data Input dataTable.
     */
    @Given("I change the list to other board:")
    public void iChangeTheListToOtherBoard(final Map<String, String> data) {
        board.changeListToBoard(data.get("Board"));
    }

    /**
     * Method for open the board.
     *
     * @param data Input dataTable.
     */
    @When("I open the board")
    public void iOpenTheBoard(final Map<String, String> data) {
        sideBarMain.searchBoard(data.get("Board"));
    }

    /**
     * Method for verify that the list exist in the board.
     *
     * @param data Input dataTable.
     */
    @Then("I should see the list in the board:")
    public void iShouldSeeTheListInTheBoard(final Map<String, String> data) {
        //To do
    }
}
