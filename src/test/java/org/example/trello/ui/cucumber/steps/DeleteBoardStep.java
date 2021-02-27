package org.example.trello.ui.cucumber.steps;


import io.cucumber.java.en.And;

import org.example.trello.ui.pages.board.CloseBoardWraper;
import org.example.trello.ui.pages.board.MenuBoard;
import org.example.trello.ui.pages.board.MenuMoreBoard;
import org.example.trello.ui.pages.board.SelectedBoard;

/**
 * Step definitions for Delete dashboard.
 */
public class DeleteBoardStep {

    private SelectedBoard selectedBoard;
    private MenuBoard menuBoard;
    private MenuMoreBoard menuMoreBoard;
    private CloseBoardWraper closeBoardWraper;

    /**
     * Constructor Delete Board.
     *
     * @param selectedBoard selectedBoard.
     * @param menuBoard menuBoard.
     * @param menuMoreBoard menuMoreBoard.
     * @param closeBoardWraper closeBoardWraper.
     */
    public DeleteBoardStep(final SelectedBoard selectedBoard,
                           final MenuBoard menuBoard, final MenuMoreBoard menuMoreBoard,
                           final CloseBoardWraper closeBoardWraper) {
        this.selectedBoard = selectedBoard;
        this.menuBoard = menuBoard;
        this.menuMoreBoard = menuMoreBoard;
        this.closeBoardWraper = closeBoardWraper;
    }

    /**
     * Close open board.
     */
    @And("I close Board")
    public void iCloseBoard() {
        selectedBoard.clickShowMenu();
        menuBoard.clickInLinkMore();
        menuMoreBoard.selectLinkCloseBoard();
    }

    /**
     * Delete close board.
     */
    @And("I delete Board")
    public void iDeleteBoard() {
        closeBoardWraper.selectPermanentlyCloseBoard();
    }
}
