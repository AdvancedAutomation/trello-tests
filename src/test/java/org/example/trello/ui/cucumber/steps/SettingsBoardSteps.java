package org.example.trello.ui.cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.example.trello.ui.pages.board.MenuBoard;
import org.example.trello.ui.pages.board.MenuMoreBoard;
import org.example.trello.ui.pages.board.MenuSettingBoard;
import org.example.trello.ui.pages.board.SelectedBoard;

import static org.testng.Assert.assertEquals;

/**
 * Step definitions for the Settings Board.
 *
 */
public class SettingsBoardSteps {

    private SelectedBoard selectedBoard;
    private MenuBoard menuBoard;
    private MenuMoreBoard menuMoreBoard;
    private MenuSettingBoard menuSettingBoard;

    /**
     * Constructor Settings Board.
     *
     * @param selectedBoard selectedBoard.
     * @param menuBoard menuBoard.
     * @param menuMoreBoard menuMoreBoard.
     * @param menuSettingBoard closeBoardWraper.
     */
    public SettingsBoardSteps(final SelectedBoard selectedBoard,
                              final MenuBoard menuBoard, final MenuMoreBoard menuMoreBoard,
                              final MenuSettingBoard menuSettingBoard) {
        this.selectedBoard = selectedBoard;
        this.menuBoard = menuBoard;
        this.menuMoreBoard = menuMoreBoard;
        this.menuSettingBoard = menuSettingBoard;
    }

    /**
     * Method to I go to board settings.
     *
     */
    @When("I go to board settings")
    public void iGoToBoardSettings() {
        selectedBoard.clickShowMenu();
        menuBoard.clickInLinkMore();
        menuMoreBoard.clickInLinkSettings();
    }

    /**
     * Method to change commenting permissions.
     *
     * @param permmision type String.
     */
    @And("I change commenting permissions to {string}")
    public void iChangeCommentingPermissionsTo(final String permmision) {
        menuSettingBoard.changeCommentingPermmissionBoard(permmision.toLowerCase());
    }

    /**
     * Method to verify the change commenting permissions.
     *
     * @param permmision type String.
     */
    @Then("I should see the commenting permissions is {string}")
    public void iShouldSeeTheCommentingPermissionsIs(final String permmision) {
        assertEquals(menuMoreBoard.getPermmissionActual(permmision), permmision);
    }
}
