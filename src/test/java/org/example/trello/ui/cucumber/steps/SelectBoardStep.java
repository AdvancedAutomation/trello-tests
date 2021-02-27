package org.example.trello.ui.cucumber.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import org.example.trello.ui.pages.board.Boards;
import org.example.trello.ui.pages.board.BoardsDrawer;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

/**
 * Step definitions for Delete dashboard.
 */
public class SelectBoardStep {

    private Boards boards;
    private BoardsDrawer boardsDrawer;

    /**
     * Constructor Delete Board.
     *
     * @param boards       Boards.
     * @param boardsDrawer BoardsDrawer.
     */
    public SelectBoardStep(final Boards boards, final BoardsDrawer boardsDrawer) {
        this.boards = boards;
        this.boardsDrawer = boardsDrawer;
    }

    /**
     * Select Board by title.
     *
     * @param titleBoard input String.
     */
    @Given("I select board {string}")
    public void iSelectBoard(final String titleBoard) {
        boards.clickBtnHeaderBoard();
        boardsDrawer.clickBoardInBoardsDrawer(titleBoard);
    }

    /**
     * Verify if board exists .
     *
     * @param titleBoard title Board.
     */
    @Then("I shouldn't see the board {string}")
    public void iDonTShouldSeeTheBoard(final String titleBoard) {
        boards.clickBtnHeaderBoard();
        assertFalse(boardsDrawer.doIsExistBoard(titleBoard));
    }

    /**
     * Verify if board is close.
     *
     * @param titleBoard title Board.
     */
    @Then("The {string} board should be close")
    public void theBoardShouldBeClose(final String titleBoard) {
        boards.clickBtnHeaderBoard();
        assertEquals(boardsDrawer.getTitle().split("\n")[0], String.format("%s is closed.", titleBoard));
    }
}

