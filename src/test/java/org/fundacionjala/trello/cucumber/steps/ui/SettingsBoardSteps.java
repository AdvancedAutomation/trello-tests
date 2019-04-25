package org.fundacionjala.trello.cucumber.steps.ui;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import org.fundacionjala.trello.pages.board.MenuBoard;
import org.fundacionjala.trello.pages.board.MenuMoreBoard;
import org.fundacionjala.trello.pages.board.MenuSettingBoard;
import org.fundacionjala.trello.pages.board.SelectedBoard;

import static org.testng.Assert.assertEquals;

/**
 * Step definitions for the Settings Board.
 *
 */
public class SettingsBoardSteps {

    @Autowired
    private SelectedBoard selectedBoard;

    @Autowired
    private MenuBoard menuBoard;

    @Autowired
    private MenuMoreBoard menuMoreBoard;

    @Autowired
    private MenuSettingBoard menuSettingBoard;

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
